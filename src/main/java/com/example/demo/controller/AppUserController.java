package com.example.demo.controller;

import com.example.demo.model.user.AppUser;
import com.example.demo.model.user.Role;
import com.example.demo.security.AuthRequest;
import com.example.demo.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = "https://grocerystore-fduda354.koyeb.app/api")
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping
    public ResponseEntity<AppUser> getAppUserById(@RequestParam(name = "id") Long id){
        return ResponseEntity.status(302).body(appUserService.getAppUserById(id));
    }
    @PostMapping("/register")
    public ResponseEntity<AppUser> saveAppUser(@RequestBody AppUser appUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users").toUriString());
        return ResponseEntity.created(uri).body(this.appUserService.saveAppUser(appUser));
    }
    @PutMapping
    public ResponseEntity<AppUser> updateAppUser(@RequestBody AppUser appUser){
        return ResponseEntity.accepted().body(this.appUserService.updateAppUser(appUser));
    }

    @PostMapping("/login")
    public ResponseEntity<?> getJwt(@RequestBody AuthRequest authRequest){
         try{
            return ResponseEntity.ok().body(appUserService.getJwt(authRequest));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



}
