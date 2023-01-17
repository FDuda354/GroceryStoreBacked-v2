package com.example.demo.controller;

import com.example.demo.BaseIT;
import com.example.demo.model.basket.Basket;
import com.example.demo.model.recipt.Receipt;
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
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class ShopControllerTest extends BaseIT {

    private final MockMvc mockMvc;
    private final ObjectMapper mapper;


    @Autowired
    public ShopControllerTest(MockMvc mockMvc, ObjectMapper mapper) {
        this.mockMvc = mockMvc;
        this.mapper = mapper;
    }


    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void getReceipt_withValidUserId_thenReturn200() throws Exception {
        // When
        var result = mockMvc.perform(MockMvcRequestBuilders.get("/api/shop/receipt")
                        .param("userId", String.valueOf(13L))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        var receipt = mapper.readValue(result, Receipt.class);

        // Then
        assertNotNull(receipt);
        assertEquals(new BigDecimal("638.62200"), receipt.getTotalPrice());
        assertEquals("TenPercentDiscount", receipt.getDiscounts().get(0));
        assertEquals("FifteenPercentDiscount", receipt.getDiscounts().get(1));
        assertEquals("Apple", receipt.getEntries().get(0).product().getName());
        assertEquals(9, receipt.getEntries().get(0).quantity());
        assertEquals(LocalDate.now(), receipt.getDate());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void getReceipt_withInvalidUserId_thenReturn404() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/shop/receipt")
                        .param("userId", String.valueOf(110L))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void getReceipt_withNoMoney_thenReturn402() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/shop/receipt")
                        .param("userId", String.valueOf(8L))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isPaymentRequired());
    }

    @Test
    public void getReceipt_withNoLogin_thenReturn403() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/shop/receipt")
                        .param("userId", String.valueOf(1L))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void addProduct_withValidBasketIdAndName_thenReturn200() throws Exception {

        // When
        var result = mockMvc.perform(MockMvcRequestBuilders.post("/api/shop/product")
                        .param("basketId", String.valueOf(2L))
                        .param("name", "Apple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        var basket = mapper.readValue(result, Basket.class);

        // Then
        assertNotNull(basket);
        assertEquals(new BigDecimal("2.00"), basket.getProducts().get(0).getPrice());
        assertEquals("Apple", basket.getProducts().get(0).getName());
        assertEquals(1, basket.getBasketProducts().get(0).getQuantity());

    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void addProduct_withInvalidBasketId_thenReturn404() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/shop/product")
                        .param("basketId", String.valueOf(110L))
                        .param("name", "Apple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void addProduct_withInvalidName_thenReturn404() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/shop/product")
                        .param("basketId", String.valueOf(2L))
                        .param("name", "Apple2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void addProduct_withNoLogin_thenReturn403() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/shop/product")
                        .param("basketId", String.valueOf(2L))
                        .param("name", "Apple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void removeProduct_withValidBasketIdAndName_thenReturn200() throws Exception {

        // When
        var result = mockMvc.perform(MockMvcRequestBuilders.delete("/api/shop/basket")
                        .param("basketId", String.valueOf(1L))
                        .param("productName", "Apple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        var basket = mapper.readValue(result, Basket.class);

        // Then
        assertNotNull(basket);
        assertEquals(12, basket.getBasketProducts().size());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void removeProduct_withInvalidName_thenReturn404() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/shop/basket")
                        .param("basketId", String.valueOf(2L))
                        .param("productName", "Apple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void removeProduct_withInvalidBasketId_thenReturn404() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/shop/basket")
                        .param("basketId", String.valueOf(110L))
                        .param("productName", "Apple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void removeProduct_withInvalidNameAndBasketId_thenReturn404() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/shop/basket")
                        .param("basketId", String.valueOf(200L))
                        .param("productName", "Apple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"ROLE_USER"})
    public void removeProduct_withInvalidName_thenReturn400() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/shop/basket")
                        .param("basketId", String.valueOf(2L))
                        .param("productName", "Apple2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void removeProduct_withNoLogin_thenReturn403() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/shop/basket")
                        .param("basketId", String.valueOf(2L))
                        .param("productName", "Apple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isForbidden());
    }
}
