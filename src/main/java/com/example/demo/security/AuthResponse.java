package com.example.demo.security;

public class AuthResponse {
    private String token;
    private String username;
    private String userId;
    private String basketId;

    public AuthResponse(String token, String username, String userId, String basketId) {
        this.token = token;
        this.username = username;
        this.userId = userId;
        this.basketId = basketId;
    }

    public AuthResponse() {
    }

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
