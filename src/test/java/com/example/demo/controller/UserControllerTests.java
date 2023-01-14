package com.example.demo.controller;

import com.example.demo.model.user.AppUser;
import com.example.demo.model.user.Role;
import com.example.demo.security.SecurityConfig;
import com.example.demo.service.AppUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
public class UserControllerTests {

    private final MockMvc mockMvc;
    private final ObjectMapper mapper;

    @MockBean
    private AppUserService appUserService;

    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @MockBean
    private SecurityFilterChain securityFilterChain;

    @MockBean
    private SecurityConfig securityConfig;


    @Autowired
    public UserControllerTests(MockMvc mockMvc, ObjectMapper mapper) {
        this.mockMvc = mockMvc;
        this.mapper = mapper;

    }

    @Test
    public void shouldAddUser() throws Exception {
        //Given
        var user = AppUser.builder().id(1L).username("filip")
                .password("1234").email("filipduda99@wp.pl").role(Role.ADMIN.name()).build();
        given(appUserService.register(any(AppUser.class),any(HttpServletRequest.class))).willReturn(user);

        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/users/register")
                        .content(mapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString(), AppUser.class);

        //Then
        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getPassword(), result.getPassword());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getRole(), result.getRole());

    }


    @Test
    public void shouldDeleteUser() throws Exception {
        //Given
        var user = AppUser.builder().id(1L).username("filip")
                .password("1234").email("filipduda99@wp.pl").role(Role.ADMIN.name()).build();

        //When
        var result = mockMvc.perform(MockMvcRequestBuilders.delete("/users")
                        .param("id", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        //Then
        assertNotNull(result);


    }

    @Test
    public void shouldGetUserById() throws Exception {
        //Given
        var user = AppUser.builder().id(1L).username("filip")
                .password("1234").email("filipduda99@wp.pl").role(Role.ADMIN.name()).build();
        given(appUserService.getAppUserById(any(Long.class))).willReturn(user);

        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .param("id", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isFound())
                .andReturn().getResponse().getContentAsString(), AppUser.class);

        //Then
        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getPassword(), result.getPassword());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getRole(), result.getRole());
    }

    @Test
    public void shouldUpdateUser() throws Exception {
        //Given
        var user = AppUser.builder().id(1L).username("filip")
                .password("1234").email("filipduda99@wp.pl").role(Role.ADMIN.name()).build();
        given(appUserService.updateAppUser(any(AppUser.class))).willReturn(user);

        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.put("/users")
                        .content(mapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(), AppUser.class);

        //Then
        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getPassword(), result.getPassword());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getRole(), result.getRole());
    }




}
