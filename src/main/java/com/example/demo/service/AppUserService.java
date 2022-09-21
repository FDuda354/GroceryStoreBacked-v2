package com.example.demo.service;

import com.example.demo.model.basket.Basket;
import com.example.demo.model.user.AppUser;
import com.example.demo.model.user.Role;
import com.example.demo.repository.BasketRepo;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserService implements  UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;


    public AppUser saveAppUser(AppUser appUser) {
        log.info("Saving new user {} to the database", appUser.getUsername());
        appUser.setBasket(new Basket());
        appUser.getBasket().setOwner(appUser.getUsername());
        return userRepo.save(appUser);
    }

    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

//    public void addRoleToAppUser(String username, String roleName) {
//        log.info("Adding role {} to user {}", roleName, username);
//        AppUser appUser = userRepo.findByUsername(username);
//        Role role = roleRepo.findByName(roleName);
//        appUser.getRoles().add(role);
//    }

    public AppUser getAppUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    public List<AppUser> getAppUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }

    //TODO: change to return plain user
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
             AppUser user = userRepo.findByUsername(username);
             if (user == null) {
                 log.error("User not found in the database");
                 throw new UsernameNotFoundException("User not found in the database");
             } else {
                 log.info("User found in the database: {}", username);
                 Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//                 user.getRoles().forEach(role -> {
//                     authorities.add(new SimpleGrantedAuthority(role.getName()));
//                 });
                 return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true,true,true,true,authorities);
             }
    }
}
