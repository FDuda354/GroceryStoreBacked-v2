package com.example.demo.controller;

import com.example.demo.model.basket.Basket;
import com.example.demo.model.product.Product;
import com.example.demo.model.product.ProductType;
import com.example.demo.model.recipt.Receipt;
import com.example.demo.model.recipt.ReceiptGenerator;
import com.example.demo.service.AppUserService;
import com.example.demo.service.ShopService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShopController.class)
public class ShopControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper mapper;
    @MockBean
    private ShopService shopService;

    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @MockBean
    private AppUserService appUserService;

    @Autowired
    public ShopControllerTest(MockMvc mockMvc, ObjectMapper mapper) {
        this.mockMvc = mockMvc;
        this.mapper = mapper;
    }

    @Test
    public void shouldGetReceipt() throws Exception {
        //Given
        var basket = new Basket();
        basket.addProduct(new Product(1L,"Apple", ProductType.FRUITS, new BigDecimal(2)));
        basket.addProduct( new Product(12L,"Bread", ProductType.GRAINS, new BigDecimal(5)));
        basket.addProduct( new Product(12L,"Bread", ProductType.GRAINS, new BigDecimal(5)));
        basket.addProduct( new Product(12L,"Bread", ProductType.GRAINS, new BigDecimal(5)));
        basket.addProduct( new Product(11L,"Steak", ProductType.MEAT, new BigDecimal(50)));
        basket.addProduct( new Product(12L,"Bread", ProductType.GRAINS, new BigDecimal(5)));
        var receiptGenerator = new ReceiptGenerator();
        var receipt = receiptGenerator.generate(basket);
        given(shopService.getReceipt(any(Long.class))).willReturn(receipt);

        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.get("/shop/receipt")
                        .param("basketId", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(), Receipt.class);



        //Then
        assertNotNull(result);
        assertEquals(receipt.getTotalPrice(), result.getTotalPrice());
        assertEquals(receipt.getEntries().size(), result.getEntries().size());
        assertEquals(receipt.getEntries().get(0).product().getName(), result.getEntries().get(0).product().getName());
        assertEquals(receipt.getEntries().get(0).product().getPrice(), result.getEntries().get(0).product().getPrice());
        assertEquals(receipt.getEntries().get(0).product().getType(), result.getEntries().get(0).product().getType());
        assertEquals(receipt.getEntries().get(0).quantity(), result.getEntries().get(0).quantity());
        assertEquals(receipt.getEntries().get(0).totalPrice(), result.getEntries().get(0).totalPrice());


    }

    @Test
    public void shouldAddProduct() throws Exception {
        //Given
        var basket = new Basket(2L,new ArrayList<>(),"user");
        var product = new Product(1L,"Apple", ProductType.FRUITS, new BigDecimal(2));
        basket.addProduct(product);
        given(shopService.addProduct(any(Long.class),any(String.class))).willReturn(basket);

        //When
        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/shop/product")
                        .param("basketId", "2")
                        .param("name", "Apple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(product))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString(), Basket.class);

        //Then
        assertNotNull(result);
        assertEquals(product.getId(), result.getProducts().get(0).getId());
        assertEquals(product.getName(), result.getProducts().get(0).getName());
        assertEquals(product.getPrice(), result.getProducts().get(0).getPrice());
        assertEquals(product.getType(), result.getProducts().get(0).getType());

    }


}
