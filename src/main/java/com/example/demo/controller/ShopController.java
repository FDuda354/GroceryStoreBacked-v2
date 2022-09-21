package com.example.demo.controller;

import com.example.demo.model.basket.Basket;
import com.example.demo.model.product.Product;
import com.example.demo.model.recipt.Receipt;
import com.example.demo.model.user.AppUser;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

   private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/getReceipt")
    public ResponseEntity<Receipt> getReceipt(@RequestParam(name = "basketId") Long basketId) {
        return shopService.getReceipt(basketId);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Basket> addProduct(@RequestParam(name = "basketId") Long basketId, @RequestParam(name = "name") String productName) {
        return shopService.addProduct(basketId,productName);
    }

}
