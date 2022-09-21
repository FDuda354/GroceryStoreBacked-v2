package com.example.demo.repository;

import com.example.demo.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);

}
