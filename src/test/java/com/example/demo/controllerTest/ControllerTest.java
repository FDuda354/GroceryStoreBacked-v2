package com.example.demo.controllerTest;

import com.example.demo.controller.ShopController;
import com.example.demo.model.basket.Basket;
import com.example.demo.model.product.Product;
import com.example.demo.model.product.ProductType;
import com.example.demo.model.recipt.Receipt;
import com.example.demo.model.recipt.ReceiptGenerator;
import com.example.demo.service.ShopService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShopController.class)
public class ControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @MockBean
//    private ShopService shopService;
//
//    @Autowired
//    ObjectMapper mapper;
//
//
//    @Test
//    public void shouldGetReceipt() throws Exception {
//        //given
//        Basket basket = new Basket();
//        basket.addProduct(new Product(1L,"Apple", ProductType.FRUITS, new BigDecimal(2)));
//        basket.addProduct( new Product(12L,"Bread", ProductType.GRAINS, new BigDecimal(5)));
//        basket.addProduct( new Product(12L,"Bread", ProductType.GRAINS, new BigDecimal(5)));
//        basket.addProduct( new Product(12L,"Bread", ProductType.GRAINS, new BigDecimal(5)));
//        basket.addProduct( new Product(11L,"Steak", ProductType.MEAT, new BigDecimal(50)));
//        basket.addProduct( new Product(12L,"Bread", ProductType.GRAINS, new BigDecimal(5)));
//        ReceiptGenerator receiptGenerator = new ReceiptGenerator();
//        Receipt receipt = receiptGenerator.generate(basket);
//        given(shopService.getReceipt()).willReturn(new ResponseEntity<>(receipt, HttpStatus.FOUND));
//
//        //when
//        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.get("/shop/getReceipt")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().isFound())
//                .andReturn().getResponse().getContentAsString(), Receipt.class);
//
//
//
//        //then
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/shop/getReceipt")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isFound())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.totalPrice",Matchers.is(result.getTotalPrice().intValue())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries.size()",Matchers.is(result.getEntries().size())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[0].product.name",Matchers.is(result.getEntries().get(0).product().getName())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[0].product.price",Matchers.is(result.getEntries().get(0).product().getPrice().intValue())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[0].product.type",Matchers.is(result.getEntries().get(0).product().getType().name())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[0].quantity",Matchers.is(result.getEntries().get(0).quantity())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[0].totalPrice",Matchers.is(result.getEntries().get(0).totalPrice().intValue())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[1].product.name",Matchers.is(result.getEntries().get(1).product().getName())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[1].product.price",Matchers.is(result.getEntries().get(1).product().getPrice().intValue())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[1].product.type",Matchers.is(result.getEntries().get(1).product().getType().name())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[1].quantity",Matchers.is(result.getEntries().get(1).quantity())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[1].totalPrice",Matchers.is(result.getEntries().get(1).totalPrice().intValue())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[2].product.name",Matchers.is(result.getEntries().get(2).product().getName())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[2].product.price",Matchers.is(result.getEntries().get(2).product().getPrice().intValue())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[2].product.type",Matchers.is(result.getEntries().get(2).product().getType().name())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[2].quantity",Matchers.is(result.getEntries().get(2).quantity())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.entries[2].totalPrice",Matchers.is(result.getEntries().get(2).totalPrice().intValue())))
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//    }
//
//    @Test
//    public void shouldAddProduct() throws Exception {
//        //given
//        Basket basket = new Basket();
//        Product product = new Product(1L, "Apple", ProductType.FRUITS, new BigDecimal(2));
//        basket.addProduct(new Product(1L, "Apple", ProductType.FRUITS, new BigDecimal(2)));
//        basket.addProduct(new Product(12L, "Bread", ProductType.GRAINS, new BigDecimal(5)));
//        basket.addProduct(new Product(12L, "Bread", ProductType.GRAINS, new BigDecimal(5)));
//        basket.addProduct(new Product(12L, "Bread", ProductType.GRAINS, new BigDecimal(5)));
//        basket.addProduct(new Product(11L, "Steak", ProductType.MEAT, new BigDecimal(50)));
//        basket.addProduct(new Product(12L, "Bread", ProductType.GRAINS, new BigDecimal(5)));
//        ReceiptGenerator receiptGenerator = new ReceiptGenerator();
//        Receipt receipt = receiptGenerator.generate(basket);
//        given(shopService.addProduct(any(Long.class),any(String.class))).willReturn(new ResponseEntity<>(product, HttpStatus.FOUND));
//
//        //when
//        var result = mapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/shop/addProduct")
//                        .param("name", "Apple")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().isFound())
//                .andReturn().getResponse().getContentAsString(), Product.class);
//
//        //then
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/shop/addProduct")
//                        .param("name", "Apple")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isFound())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name",Matchers.is(result.getName())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.price",Matchers.is(result.getPrice().intValue())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.type",Matchers.is(result.getType().name())))
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//    }

}
