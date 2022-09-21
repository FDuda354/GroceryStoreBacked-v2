package com.example.demo.controller;

import com.example.demo.model.basket.Basket;
import com.example.demo.model.user.AppUser;
import com.example.demo.model.user.Role;
import com.example.demo.service.AppUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>>getAppUser(){
        return ResponseEntity.ok().body(appUserService.getAppUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveAppUser(@RequestBody AppUser appUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(this.appUserService.saveAppUser(appUser));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(this.appUserService.saveRole(role));
    }

//    @PostMapping("/role/addtouser")
//    public ResponseEntity<?> addRoleToAppUser(@RequestBody RoleToUserForm form){
//        this.appUserService.addRoleToAppUser(form.getUsername(), form.getRoleName());
//        return ResponseEntity.ok().build();
//    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB()
    {

        appUserService.saveRole(new Role(null, "ROLE_USER"));
        appUserService.saveRole(new Role(null, "ROLE_MANAGER"));
        appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
        appUserService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

        appUserService.saveAppUser(AppUser.builder().username("john").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true).password("1234").email("johnduda99@wp.pl").build());
        appUserService.saveAppUser(AppUser.builder().username("tom").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true).password("1234").email("tom99@wp.pl").build());
        appUserService.saveAppUser(AppUser.builder().username("jane").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true).password("1234").email("jane99Wp.pl").build());
        appUserService.saveAppUser(AppUser.builder().username("filip").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true).password("1234").email("filipduda99@wp.pl").build());

//        appUserService.addRoleToAppUser("john", "ROLE_USER");
//        appUserService.addRoleToAppUser("tom", "ROLE_MANAGER");
//        appUserService.addRoleToAppUser("jane", "ROLE_ADMIN");
//        appUserService.addRoleToAppUser("filip", "ROLE_SUPER_ADMIN");
//        appUserService.addRoleToAppUser("filip", "ROLE_ADMIN");


    }
}
@Data
class RoleToUserForm{
    private String username;
    private String roleName;

}