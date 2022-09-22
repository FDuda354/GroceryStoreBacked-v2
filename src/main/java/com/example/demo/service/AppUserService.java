package com.example.demo.service;

import com.example.demo.model.basket.Basket;
import com.example.demo.model.user.AppUser;
import com.example.demo.model.user.Role;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
//@Qualifier("myUserDetailsService")
public class AppUserService implements  UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder passwordEncoder;


    public AppUser saveAppUser(AppUser appUser) {
        log.info("Saving new user {} to the database", appUser.getUsername());
        return userRepo.save(this.userBuilder(appUser));
    }

    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    public void addRoleToAppUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        AppUser appUser = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        appUser.getRoles().add(role);
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepo.findByUsername(username);
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return user;
            //return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true,true,true,true,authorities);
        }
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
        appUser.setRoles(new HashSet<>());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUser;
    }

    public AppUser updateAppUser(AppUser appUser) {

        if(userRepo.existsById(appUser.getId())) {
            AppUser appUser1 = userRepo.findById(appUser.getId()).get();
            appUser1.setUsername(appUser.getUsername());
            appUser1.setPassword(passwordEncoder.encode(appUser.getPassword()));
            appUser1.setRoles(appUser.getRoles());
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
}
