package com.example.demo.controller;

import com.example.demo.model.basket.Basket;
import com.example.demo.model.product.Product;
import com.example.demo.model.recipt.Receipt;
import com.example.demo.model.user.AppUser;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

   private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/receipt")
    public ResponseEntity<Receipt> getReceipt(@RequestParam(name = "basketId") Long basketId) {
        return ResponseEntity.ok().body(shopService.getReceipt(basketId));
    }

    @PostMapping("/product")
    public ResponseEntity<Basket> addProduct(@RequestParam(name = "basketId") Long basketId, @RequestParam(name = "name") String name) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/shop/product").toUriString());
        return ResponseEntity.created(uri).body(shopService.addProduct(basketId, name));
    }

}
