package com.example.demo.controller;

import com.example.demo.BaseIT;
import com.example.demo.model.product.Product;
import com.example.demo.model.product.ProductType;
import com.example.demo.model.user.AppUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class AdminPanelControllerTest extends BaseIT {

    private final MockMvc mockMvc;
    private final ObjectMapper mapper;


    @Autowired
    public AdminPanelControllerTest(MockMvc mockMvc, ObjectMapper mapper) {
        this.mockMvc = mockMvc;
        this.mapper = mapper;
    }

    @Test
    @WithMockUser(username = "admin", authorities = {"ROLE_ADMIN"})
    public void getAllAppUsers_withRoleAdmin_thenReturn200() throws Exception {

        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(), AppUser[].class);

        //Then
        assertNotNull(result);
        assertEquals(13, result.length);
        assertEquals(1, result[0].getId());
        assertEquals("filip", result[0].getUsername());
        assertEquals(13, result[12].getId());
        assertEquals("pawel", result[12].getUsername());

    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void getAllAppUsers_withRoleUser_thenReturn403() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isForbidden());

    }

    @Test
    @WithMockUser(username = "admin", authorities = {"ROLE_ADMIN"})
    public void AddProductToDB_withRoleAdmin_thenReturn200() throws Exception {
        //Given
        var product = new Product("test", ProductType.FRUITS, new BigDecimal("3.99"));
        var json = mapper.writeValueAsString(product);
        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/product")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(), Product.class);

        //Then
        assertNotNull(result);
        assertEquals("test", result.getName());
        assertEquals(new BigDecimal("3.99"), result.getPrice());
        assertEquals(ProductType.FRUITS, result.getType());
    }

    @Test
    @WithMockUser(username = "admin", authorities = {"ROLE_ADMIN"})
    public void whenAddProductToDB_withRoleAdmin_thenReturn409() throws Exception {
        //Given
        Product product = new Product("Banana", ProductType.FRUITS, new BigDecimal(1.99));
        var json = mapper.writeValueAsString(product);

        //When
        mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/product")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isConflict());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void whenAddProductToDB_withRoleUser_thenReturn400() throws Exception {
        //Given
        Product product = new Product("test1", ProductType.FRUITS, new BigDecimal(1.99));
        var json = mapper.writeValueAsString(product);

        //When
        mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/product")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", authorities = {"ROLE_ADMIN"})
    public void whenRemoveProductFromDB_withRoleAdmin_thenReturn204() throws Exception {
        //When
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin/product?productName=Apple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNoContent());
    }
    @Test
    @WithMockUser(username = "admin", authorities = {"ROLE_ADMIN"})
    public void whenRemoveProductFromDB_withRoleAdmin_thenReturn404() throws Exception {
        //When
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin/product?productName=InvalidProduct")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void whenRemoveProductFromDB_withRoleUser_thenReturn403() throws Exception {
        //When
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isForbidden());

    }

    @Test
    @WithMockUser(username = "admin", authorities = {"ROLE_ADMIN"})
    public void whenUpdateProductFromDB_withRoleAdmin_thenReturn200() throws Exception {
        //Given
        Product product = new Product("Apple", ProductType.FRUITS, new BigDecimal("10.99"));
        var json = mapper.writeValueAsString(product);

        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.put("/api/admin/product")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(), Product.class);

        //Then
        assertNotNull(result);
        assertEquals("Apple", result.getName());
        assertEquals(new BigDecimal("10.99"), result.getPrice());
        assertEquals(ProductType.FRUITS, result.getType());
    }

    @Test
    @WithMockUser(username = "admin", authorities = {"ROLE_ADMIN"})
    public void whenUpdateProductFromDB_withRoleAdmin_thenReturn404() throws Exception {
        //Given
        Product product = new Product("InvalidProduct", ProductType.FRUITS, new BigDecimal(1.99));
        var json = mapper.writeValueAsString(product);

        //When
        mockMvc.perform(MockMvcRequestBuilders.put("/api/admin/product")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void whenUpdateProductFromDB_withRoleUser_thenReturn403() throws Exception {
        //Given
        Product product = new Product("Apple", ProductType.FRUITS, new BigDecimal(1.99));
        var json = mapper.writeValueAsString(product);

        //When
        mockMvc.perform(MockMvcRequestBuilders.put("/api/admin/product")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isForbidden());
    }
    @Test
    @WithMockUser(username = "admin", authorities = {"ROLE_ADMIN"})
    public void whenDeleteUserFromDB_withRoleAdmin_thenReturn204() throws Exception {
        //When
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin?id=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNoContent());
    }

    @Test
    @WithMockUser(username = "admin", authorities = {"ROLE_ADMIN"})
    public void whenDeleteUserFromDB_withRoleAdmin_thenReturn404() throws Exception {
        //When
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin?id=100")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void whenDeleteUserFromDB_withRoleUser_thenReturn403() throws Exception {
        //When
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin?id=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isForbidden());
    }
}
