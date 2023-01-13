package com.example.demo.security;

public record AuthRequest (
        String username,
        String password) {
}