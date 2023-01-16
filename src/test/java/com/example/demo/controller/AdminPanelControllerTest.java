package com.example.demo.controller;

import com.example.demo.BaseIT;
import com.example.demo.model.basket.Basket;
import com.example.demo.model.payments.Wallet;
import com.example.demo.model.product.Product;
import com.example.demo.model.product.ProductType;
import com.example.demo.model.user.AppUser;
import com.example.demo.model.user.Role;
import com.example.demo.security.SecurityConfig;
import com.example.demo.service.AdminPanelService;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
public class AdminPanelControllerTest extends BaseIT {

    private final MockMvc mockMvc;
    private final ObjectMapper mapper;

    @MockBean
    private AdminPanelService adminPanelService;

    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @MockBean
    private SecurityFilterChain securityFilterChain;
    @MockBean
    private SecurityConfig securityConfig;

    @MockBean
    private AppUserController appUserController;

    @MockBean
    private AppUserService appUserService;


    @Autowired
    public AdminPanelControllerTest(MockMvc mockMvc, ObjectMapper mapper) {
        this.mockMvc = mockMvc;
        this.mapper = mapper;

    }

    @Test
    public void shouldGetAllUsers() throws Exception {
        //Given
        var userList = List.of(AppUser.builder().id(1L).username("filip")
                        .password("1234").email("filipduda99@wp.pl").wallet(Wallet.builder()
                                .balance(new BigDecimal(500))
                                .owner("filip")
                                .transactions(new ArrayList<>())
                                .build()).role("ROLE_"+Role.ADMIN).basket(new Basket("filip")).build(),
                AppUser.builder().id(2L).username("filip")
                        .password("1234").email("filipduda99@wp.pl").wallet(Wallet.builder()
                                .balance(new BigDecimal(500))
                                .owner("filip")
                                .transactions(new ArrayList<>())
                                .build()).role("ROLE_"+Role.ADMIN).basket(new Basket("filip")).build(),
                AppUser.builder().id(3L).username("filip")
                        .password("1234").email("filipduda99@wp.pl").wallet(Wallet.builder()
                                .balance(new BigDecimal(500))
                                .owner("filip")
                                .transactions(new ArrayList<>())
                                .build()).role("ROLE_"+Role.ADMIN).basket(new Basket("filip")).build());

        given(adminPanelService.getAllAppUsers()).willReturn(userList);

        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/all")
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
        assertEquals(userList.get(0).getRole(), result[0].getRole());
    }

    @Test
    public void shouldAddProductToDB() throws Exception {
        //Given
        var product = Product.builder().id(1L).name("test").type(ProductType.GRAINS)
                .price(BigDecimal.valueOf(2.00)).build();
        given(adminPanelService.addProductToDB(any(Product.class))).willReturn(product);

        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/admin/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(product)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(), Product.class);

        //Then
        assertNotNull(result);
        assertEquals(product.getId(), result.getId());
        assertEquals(product.getName(), result.getName());
        assertEquals(product.getType(), result.getType());
        assertEquals(product.getPrice(), result.getPrice());
    }

    @Test
    public void shouldDeleteProductFromDB() throws Exception {
        //Given
        var productName = "Apple";

        //When
        var result = mockMvc.perform(MockMvcRequestBuilders.delete("/admin/product/")
                        .param("name", productName)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //Then
        assertNotNull(result);
    }

}
