package com.example.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.model.basket.Basket;
import com.example.demo.model.user.AppUser;
import com.example.demo.model.user.Role;
import com.example.demo.repository.UserRepo;
import com.example.demo.security.AuthRequest;
import com.example.demo.security.AuthResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Value("${secret.key}")
    private String SECRET_KEY;

    public AppUser saveAppUser(AppUser appUser) throws Exception {
        try {
            if (userRepo.existsByUsername(appUser.getUsername())) {
                log.error("User with username: " + appUser.getUsername() + " already exists");
                throw new UserAlreadyExistException("User already exists");
            }
            return userRepo.save(userBuilder(appUser));
        } catch (Exception e) {
            log.error("Error while saving user: " + e.getMessage());
            throw new Exception("Error while saving user: " + e.getMessage());
        }

    }

    public AppUser getAppUserById(Long userId) throws Exception {
        try {
            return userRepo.findById(userId).orElseThrow(() -> {
                log.error("User with id {} not found", userId);
                return new UsernameNotFoundException("User with id " + userId + " not found");
            });
        } catch (Exception e) {
            log.error("Error while getting user by id: " + e.getMessage());
            throw new Exception("Error while getting user by id: " + e.getMessage());
        }
    }

    private AppUser userBuilder(AppUser appUser) {
        appUser.setBasket(new Basket(appUser.getUsername()));
        appUser.setRole("ROLE_" + Role.USER);
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUser;
    }

    public AppUser updateAppUser(AppUser updatedUser) throws Exception {
        try {
            var user = userRepo.findById(updatedUser.getId()).orElseThrow(() -> {
                log.error("User not found in the database");
                return new UsernameNotFoundException("User not found in the database");
            });

            if (userRepo.findByUsername(updatedUser.getUsername()).filter(u -> !u.getId().equals(updatedUser.getId())).isPresent()) {
                log.error("User with username: " + updatedUser.getUsername() + " already exists");
                throw new UserAlreadyExistException("User already exists");
            }

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
        try{
        AppUser appUser = userRepo.findById(id).orElseThrow(() -> {
            log.error("User not found in the database");
            return new UsernameNotFoundException("User not found in the database");
        });
        appUser.getBasket().removeAllProducts();
        userRepo.deleteById(id);
        } catch (Exception e) {
            log.error("Error while deleting user: " + e.getMessage());
            throw new Exception("Error while deleting user: " + e.getMessage());
        }
    }
}
