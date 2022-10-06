package com.example.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.model.basket.Basket;
import com.example.demo.model.user.AppUser;
import com.example.demo.repository.UserRepo;
import com.example.demo.security.AuthRequest;
import com.example.demo.security.AuthResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
//@Qualifier("myUserDetailsService")
public class AppUserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

//    @Value("${secret.key}")
//    private String SECRET_KEY;

    public AppUser saveAppUser(AppUser appUser) {
        log.info("Saving new user {} to the database", appUser.getUsername());
        return userRepo.save(this.userBuilder(appUser));
    }

    public AppUser getAppUserById(Long userId) {
        log.info("Getting user with id {}", userId);
        if(userRepo.findById(userId).isPresent()) {
            return userRepo.findById(userId).get();
        } else {
            log.error("User with id {} not found", userId);
            return new AppUser();
        }
    }

    public List<AppUser> getAllAppUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }

    public void deleteAppUser(Long id) {
        if(userRepo.existsById(id)) {
            AppUser appUser = userRepo.findById(id).get();
            userRepo.deleteById(id);
            log.info("User {} deleted", appUser.getUsername());
        }
        else {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }
    }

    private AppUser userBuilder(AppUser appUser) {
        appUser.setBasket(new Basket());
        appUser.getBasket().setOwner(appUser.getUsername());
        appUser.setRole("ROLE_USER");
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUser;
    }

    public AppUser updateAppUser(AppUser appUser) {

        if(userRepo.existsById(appUser.getId())) {
            AppUser appUser1 = userRepo.findById(appUser.getId()).get();
            appUser1.setUsername(appUser.getUsername());
            appUser1.setPassword(passwordEncoder.encode(appUser.getPassword()));
            appUser1.setBasket(appUser.getBasket());
            appUser1.getBasket().setOwner(appUser.getUsername());
            log.info("User {} updated", appUser.getUsername());
            return appUser1;
        }
        else {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }
    }

    public AuthResponse getJwt(AuthRequest authRequest){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            AppUser appUser = (AppUser) authentication.getPrincipal();

            Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
            String token = JWT.create()
                    .withIssuer("GroceryStore")
                    .withSubject(appUser.getUsername())
                    .withClaim("roles", appUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                    .sign(algorithm);

            return new AuthResponse(token, appUser.getUsername(), appUser.getId().toString(),appUser.getBasket().getId().toString());

        }catch (Exception e){
            return null;
        }
    }
}
