package com.example.demo.security;

public record AuthResponse(
        String token,
        String username,
        String userId,
        String basketId) {
}
