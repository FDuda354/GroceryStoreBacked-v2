package com.example.demo.controller;

import com.example.demo.BaseIT;
import com.example.demo.exception.UserNotFoundInDBException;
import com.example.demo.model.basket.Basket;
import com.example.demo.model.recipt.Receipt;
import com.example.demo.model.user.AppUser;
import com.example.demo.security.AuthRequest;
import com.example.demo.security.AuthResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
public class UserControllerTests extends BaseIT {

    private final MockMvc mockMvc;
    private final ObjectMapper mapper;


    @Autowired
    public UserControllerTests(MockMvc mockMvc, ObjectMapper mapper) {
        this.mockMvc = mockMvc;
        this.mapper = mapper;
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void getUser_withValidUserId_thenReturn302() throws Exception {
        // When
        var result = mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
                        .param("id", String.valueOf(1))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andReturn().getResponse().getContentAsString();
        var user = mapper.readValue(result, AppUser.class);

        // Then
        assertNotNull(user);
        assertEquals("filip", user.getUsername());
        assertEquals("duda.filip99@gmail.com", user.getEmail());
        assertEquals("ROLE_ADMIN", user.getRole());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void getUser_withInvalidUserId_thenReturn404() throws Exception {
        // When
        var result = mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
                        .param("id", String.valueOf(100L))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn().getResponse().getContentAsString();

        // Then
        assertEquals("", result);
    }

    @Test
    public void getUser_withValidUserId_thenReturn403() throws Exception {
        // When
        var result = mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
                        .param("id", String.valueOf(1L))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden())
                .andReturn().getResponse().getContentAsString();

        // Then
        assertEquals("", result);
    }

//    @Test
//    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
//    public void updateAppUser_withValidUser_thenReturn302() throws Exception {
//        // Given
//        var appUser = new AppUser();
//        appUser.setId(1L);
//        appUser.setUsername("filip2");
//        appUser.setEmail("duda.filip99@gmail.com2");
//        appUser.setRole("ROLE_USER");
//
//        // When
//
//        var result = mockMvc.perform(MockMvcRequestBuilders.put("/api/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(mapper.writeValueAsString(appUser))
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isFound())
//                .andReturn().getResponse().getContentAsString();
//
//        var user = mapper.readValue(result, AppUser.class);
//
//        // Then
//
//        assertNotNull(user);
//        assertEquals("filip2", user.getUsername());
//        assertEquals("duda.filip99@gmail.com2", user.getEmail());
//        assertEquals("ROLE_USER", user.getRole());
//    }
//
//    @Test
//    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
//    public void updateAppUser_withInvalidUser_thenReturn404() throws Exception {
//        // Given
//        var appUser = new AppUser();
//        appUser.setId(100L);
//        appUser.setUsername("filip2");
//        appUser.setEmail("duda.filip99@gmail.com2");
//        appUser.setRole("ROLE_USER");
//
//        // When
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(mapper.writeValueAsString(appUser))
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());
//
//    }

    @Test
    public void updateAppUser_withValidUser_thenReturn403() throws Exception {
        // Given
        var appUser = new AppUser();
        appUser.setId(1L);
        appUser.setUsername("filip2");
        appUser.setEmail("duda.filip99@gmail.com2");
        appUser.setRole("ROLE_USER");

        // When
        mockMvc.perform(MockMvcRequestBuilders.put("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(appUser))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void deleteAppUser_withValidUser_thenReturn302() throws Exception {
        // When
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/users")
                        .param("id", String.valueOf(1L))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void deleteAppUser_withInvalidUser_thenReturn404() throws Exception {
        // When
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/users")
                        .param("id", String.valueOf(100L))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteAppUser_withValidUser_thenReturn403() throws Exception {
        // When
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/users")
                        .param("id", String.valueOf(1L))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    public void getJwt_withValidUser_thenReturn200() throws Exception {
        // Given
        var authRequest = new AuthRequest("filip", "1234");

        // When
        var result = mockMvc.perform(MockMvcRequestBuilders.post("/api/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(authRequest))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        var authResponse = mapper.readValue(result, AuthResponse.class);

        // Then
        assertNotNull(authResponse);
        assertNotNull(authResponse.username(), "filip");
        assertNotNull(authResponse.basketId(), String.valueOf(1L));
        assertNotNull(authResponse.userId(), String.valueOf(1L));

    }

    @Test
    public void getJwt_withInvalidUser_thenReturn404() throws Exception {
        // Given
        var authRequest = new AuthRequest("invalidUserName", "invalidPassword");

        // When
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(authRequest))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
