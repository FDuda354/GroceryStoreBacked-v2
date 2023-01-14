package com.example.demo.controller;

import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundInDBException;
import com.example.demo.model.user.AppUser;
import com.example.demo.security.AuthRequest;
import com.example.demo.security.AuthResponse;
import com.example.demo.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class AppUserController {

    private final AppUserService userService;

    @GetMapping
    public ResponseEntity<AppUser> getAppUserById(@RequestParam(name = "id") Long id) {
        try {
            return ResponseEntity.status(302).body(userService.getAppUserById(id));
        } catch (UserNotFoundInDBException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> saveAppUser(@RequestBody AppUser appUser, HttpServletRequest request) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/register").toUriString());
            return ResponseEntity.created(uri).body(userService.register(appUser,request));
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.status(409).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/confirm")
    public ResponseEntity<String> confirm(@RequestParam String token)  {
        return ResponseEntity.ok(userService.confirm(token));
    }
    @PutMapping
    public ResponseEntity<AppUser> updateAppUser(@RequestBody AppUser appUser) {
        try {
            return ResponseEntity.status(302).body(userService.updateAppUser(appUser));
        } catch (UserNotFoundInDBException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAppUser(@RequestParam(name = "id") Long id) {
        try {
            userService.deleteAppUser(id);
            return ResponseEntity.ok().build();
        } catch (UserNotFoundInDBException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> getJwt(@RequestBody AuthRequest authRequest) {
        try {
            return ResponseEntity.ok().body(userService.getJwt(authRequest));
        } catch (UserNotFoundInDBException e) {
            return ResponseEntity.notFound().build();
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).build();
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
