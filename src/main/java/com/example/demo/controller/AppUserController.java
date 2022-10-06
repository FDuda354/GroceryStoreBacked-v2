package com.example.demo.controller;

import com.example.demo.model.user.AppUser;
import com.example.demo.security.AuthRequest;
import com.example.demo.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class AppUserController {

    private final AppUserService appUserService;


    @GetMapping("/all")
    public ResponseEntity<List<AppUser>>getAllAppUsers(){
        return ResponseEntity.ok().body(appUserService.getAllAppUsers());
    }
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
    @DeleteMapping
    public ResponseEntity<?> deleteAppUser(@RequestParam(name = "id") Long id){
        this.appUserService.deleteAppUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> getJwt(@RequestBody AuthRequest authRequest){
         try{
            return ResponseEntity.ok().body(appUserService.getJwt(authRequest));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDB()
//    {
//        appUserService.saveAppUser(AppUser.builder().username("john").password("1234").email("johnduda99@wp.pl").role("ROLE_"+Role.USER.name()).build());
//        appUserService.saveAppUser(AppUser.builder().username("tom").password("1234").email("tom99@wp.pl").role("ROLE_"+Role.USER.name()).build());
//        appUserService.saveAppUser(AppUser.builder().username("jane").password("1234").email("jane99Wp.pl").role("ROLE_"+Role.USER.name()).build());
//        appUserService.saveAppUser(AppUser.builder().username("filip").password("1234").email("filipduda99@wp.pl").role("ROLE_"+Role.ADMIN.name()).build());
//
//    }
}
