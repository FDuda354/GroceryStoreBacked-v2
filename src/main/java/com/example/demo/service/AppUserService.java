package com.example.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.exception.OutOfMoneyException;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.model.basket.Basket;
import com.example.demo.model.payments.Wallet;
import com.example.demo.model.recipt.Receipt;
import com.example.demo.model.user.AppUser;
import com.example.demo.model.user.Role;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.VerificationTokenRepo;
import com.example.demo.security.AuthRequest;
import com.example.demo.security.AuthResponse;
import com.example.demo.security.mail.MailService;
import com.example.demo.security.mail.VerificationToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final VerificationTokenRepo verificationTokenRepo;
    private final MailService mailService;

    @Value("${secret.key}")
    private String SECRET_KEY;

    public AppUser register(AppUser user, HttpServletRequest request) throws Exception {

        if (userRepo.existsByUsername(user.getUsername())) {
            log.error("User with username: " + user.getUsername() + " already exists");
            throw new UserAlreadyExistException("User already exists");
        }
        try {

            String token = UUID.randomUUID().toString();
            VerificationToken verificationToken = new VerificationToken(token, user);
            verificationTokenRepo.save(verificationToken);

            String url = "http://" + request.getServerName() + ":" + request.getServerPort() + "/api/users/confirm?token=" + token;

            //mailService.sendMail(user.getEmail(), "Confirm your account", url, false);

            return userRepo.save(userBuilder(user));

        } catch (Exception e) {
            log.error("Error while saving user: " + e.getMessage());
            throw new Exception("Error while saving user: " + e.getMessage());
        }

    }

    public String confirm(String token) {
        VerificationToken verificationToken = verificationTokenRepo.findByValue(token).orElseThrow(() -> new UsernameNotFoundException("Token not found"));
        AppUser user = verificationToken.getUser();
        user.setEnable(true);
        userRepo.save(user);
        return "Account confirmed";
    }

    public AppUser getAppUserById(Long userId) throws UsernameNotFoundException {

        return userRepo.findById(userId).orElseThrow(() -> {
            log.error("User with id {} not found", userId);
            throw new UsernameNotFoundException("User with id " + userId + " not found");
        });

    }

    private AppUser userBuilder(AppUser appUser) {
        appUser.setBasket(new Basket(appUser.getUsername()));
        appUser.setRole("ROLE_" + Role.USER);
        appUser.setWallet(new Wallet(new BigDecimal(100), new ArrayList<>(), appUser.getUsername()));
        appUser.setEnable(false);
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUser;
    }

    public AppUser updateAppUser(AppUser updatedUser) throws Exception {

        var user = userRepo.findById(updatedUser.getId()).orElseThrow(() -> {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        });

        if (userRepo.findByUsername(updatedUser.getUsername()).filter(u -> !u.getId().equals(updatedUser.getId())).isPresent()) {
            log.error("User with username: " + updatedUser.getUsername() + " already exists");
            throw new UserAlreadyExistException("User already exists");
        }
        try {
            user.setUsername(updatedUser.getUsername());
            user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            user.setEmail(updatedUser.getEmail());
            user.setBasket(updatedUser.getBasket());
            user.getBasket().setOwner(updatedUser.getUsername());
            return userRepo.save(user);
        } catch (Exception e) {
            log.error("Error while updating user: " + e.getMessage());
            throw new Exception("Error while updating user: " + e.getMessage());
        }
    }


    public AuthResponse getJwt(AuthRequest authRequest) {
        AppUser appUser = userRepo.findByUsername(authRequest.username())
                .orElseThrow(() -> new UsernameNotFoundException("User not found in the database"));
        if (!passwordEncoder.matches(authRequest.password(), appUser.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }
        if (!appUser.isEnabled()) {
            throw new BadCredentialsException("User is not confirmed");
        }
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());
        String token = JWT.create()
                .withIssuer("GroceryStore")
                .withSubject(appUser.getUsername())
                .withClaim("roles", appUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
        return new AuthResponse(token, appUser.getUsername(), appUser.getId().toString(), appUser.getBasket().getId().toString());
    }

    public void deleteAllUsers() throws Exception {
        try {
            List<AppUser> appUsers = userRepo.findAll();
            appUsers.forEach(appUser -> {
                appUser.getBasket().removeAllProducts();
            });
            userRepo.deleteAll();
        } catch (Exception e) {
            log.error("Error while deleting all users: " + e.getMessage());
            throw new Exception("Error while deleting all users: " + e.getMessage());
        }
    }

    public void deleteAppUser(Long id) throws Exception {
        AppUser appUser = userRepo.findById(id).orElseThrow(() -> {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        });
        try {
            appUser.getBasket().removeAllProducts();
            userRepo.deleteById(id);
        } catch (Exception e) {
            log.error("Error while deleting user: " + e.getMessage());
            throw new Exception("Error while deleting user: " + e.getMessage());
        }
    }

    @Transactional(rollbackFor = OutOfMoneyException.class)
    public void payForProducts(Receipt receipt, Wallet wallet, Basket basket) throws Exception {
        wallet.removeMoney(receipt.getTotalPrice(), receipt.getTypeOfProduct());
        try {
            basket.removeAllProducts();
        } catch (Exception e) {
            log.error("Error while paying for product: " + e.getMessage());
            throw new Exception("Error while paying for product: " + e.getMessage());
        }
    }
}
