package com.example.demo.controller;

import com.example.demo.model.product.Product;
import com.example.demo.model.recipt.Receipt;
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

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getProducts() {
        return shopService.getProducts();
    }

    @GetMapping("/getReceipt")
    public ResponseEntity<Receipt> getReceipt() {
        return shopService.getReceipt();
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestParam(name = "name") String productName) {
        return shopService.addProduct(productName);
    }

}
