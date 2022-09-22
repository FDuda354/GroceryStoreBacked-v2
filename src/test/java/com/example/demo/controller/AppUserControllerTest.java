package com.example.demo.controller;

import com.example.demo.model.user.AppUser;
import com.example.demo.model.user.Role;
import com.example.demo.security.SecurityConfig;
import com.example.demo.service.AppUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AppUserController.class)
public class AppUserControllerTest {


    private final MockMvc mockMvc;
    private final ObjectMapper mapper;



    @MockBean
    private AppUserService appUserService;

    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public AppUserControllerTest(MockMvc mockMvc, ObjectMapper mapper) {
        this.mockMvc = mockMvc;
        this.mapper = mapper;
    }

    @Test
    public void shouldAddAppUser() throws Exception {
        //Given
        var user = AppUser.builder().id(1L).username("filip").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true)
                .password("1234").email("filipduda99@wp.pl").roles(new HashSet<>()).build();
        given(appUserService.saveAppUser(any(AppUser.class))).willReturn(user);

        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/users")
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
        assertEquals(user.getRoles(), result.getRoles());


    }

    @Test
    public void shouldGetAllUsers() throws Exception {
        //Given
        var userList = List.of(AppUser.builder().id(1L).username("filip").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true)
                        .password("1234").email("filipduda99@wp.pl").roles(new HashSet<>()).build(),
                AppUser.builder().id(2L).username("jan").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true)
                        .password("1234").email("janKowalski@wp.pl").roles(new HashSet<>()).build(),
                AppUser.builder().id(3L).username("kasia").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true)
                        .password("1234").email("kasia12@wp.pl").roles(new HashSet<>()).build());
        given(appUserService.getAllAppUsers()).willReturn(userList);

        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.get("/users/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(), AppUser[].class);

        //Then
        assertNotNull(result);
        assertEquals(userList.size(), result.length);
        assertEquals(userList.get(0).getId(), result[0].getId());
        assertEquals(userList.get(0).getUsername(), result[0].getUsername());
        assertEquals(userList.get(1).getPassword(), result[1].getPassword());
        assertEquals(userList.get(2).getEmail(), result[2].getEmail());
        assertEquals(userList.get(0).getRoles(), result[0].getRoles());
    }

    @Test
    public void shouldDeleteUser() throws Exception {
        //Given
        var user = AppUser.builder().id(1L).username("filip").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true)
                .password("1234").email("filipduda99@wp.pl").roles(new HashSet<>()).build();

        //When
        var result = mockMvc.perform(MockMvcRequestBuilders.delete("/users")
                        .param("id", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNoContent())
                .andReturn().getResponse().getContentAsString();
        //Then
        assertNotNull(result);


    }

    @Test
    public void shouldGetUserById() throws Exception {
        //Given
        var user = AppUser.builder().id(1L).username("filip").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true)
                .password("1234").email("filipduda99@wp.pl").roles(new HashSet<>()).build();
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
        assertEquals(user.getRoles(), result.getRoles());
    }

    @Test
    public void shouldUpdateUser() throws Exception {
        //Given
        var user = AppUser.builder().id(1L).username("filip").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true)
                .enabled(true).password("1234").email("filipduda99@wp.pl").roles(new HashSet<>()).build();
        given(appUserService.updateAppUser(any(AppUser.class))).willReturn(user);

        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.put("/users")
                        .content(mapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isAccepted())
                .andReturn().getResponse().getContentAsString(), AppUser.class);

        //Then
        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getPassword(), result.getPassword());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getRoles(), result.getRoles());

    }

    @Test
    public void shouldsaveRole() throws Exception {
        //Given
        var role = Role.builder().id(1L).name("ROLE_USER").build();
        given(appUserService.saveRole(any(Role.class))).willReturn(role);

        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/users/role")
                        .content(mapper.writeValueAsString(role))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString(), Role.class);

        //Then
        assertNotNull(result);
        assertEquals(role.getId(), result.getId());
        assertEquals(role.getName(), result.getName());
    }

    @Test
    public void shouldAddRoleToAppUser() throws Exception {
        //Given
        var role = RoleToUserForm.builder().username("filip").roleName("ROLE_USER").build();
        var user = AppUser.builder().id(1L).username("filip").accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true)
                .enabled(true).password("1234").email("filipduda99@wp.pl").roles(new HashSet<>()).build();

        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/users/role/toUser")
                        .content(mapper.writeValueAsString(role))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(), RoleToUserForm.class);

        //Then
        assertNotNull(result);
        assertEquals(role.getUsername(), result.getUsername());
        assertEquals(role.getRoleName(), result.getRoleName());
    }
}