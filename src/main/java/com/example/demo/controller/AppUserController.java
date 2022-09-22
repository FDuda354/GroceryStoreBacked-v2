package com.example.demo.controller;

import com.example.demo.model.user.AppUser;
import com.example.demo.model.user.Role;
import com.example.demo.service.AppUserService;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashSet;
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
    @PostMapping
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



    @PostMapping("/role")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/role").toUriString());
        return ResponseEntity.created(uri).body(this.appUserService.saveRole(role));
    }
    @PostMapping("/role/toUser")
    public ResponseEntity<?> addRoleToAppUser(@RequestBody RoleToUserForm form){
        this.appUserService.addRoleToAppUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().body(form);
    }




    @EventListener(ApplicationReadyEvent.class)
    public void fillDB()
    {

        appUserService.saveRole(new Role( "ROLE_USER"));
        appUserService.saveRole(new Role( "ROLE_MANAGER"));
        appUserService.saveRole(new Role( "ROLE_ADMIN"));

        appUserService.saveAppUser(AppUser.builder().username("john").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true).password("1234").email("johnduda99@wp.pl").roles(new HashSet<>()).build());
        appUserService.saveAppUser(AppUser.builder().username("tom").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true).password("1234").email("tom99@wp.pl").roles(new HashSet<>()).build());
        appUserService.saveAppUser(AppUser.builder().username("jane").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true).password("1234").email("jane99Wp.pl").roles(new HashSet<>()).build());
        appUserService.saveAppUser(AppUser.builder().username("filip").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true).password("1234").email("filipduda99@wp.pl").roles(new HashSet<>()).build());

        appUserService.addRoleToAppUser("john", "ROLE_USER");
        appUserService.addRoleToAppUser("tom", "ROLE_MANAGER");
        appUserService.addRoleToAppUser("jane", "ROLE_ADMIN");
        appUserService.addRoleToAppUser("filip", "ROLE_MANAGER");
        appUserService.addRoleToAppUser("filip", "ROLE_ADMIN");


    }
}
@Data
@Builder
class RoleToUserForm{
    private String username;
    private String roleName;

}