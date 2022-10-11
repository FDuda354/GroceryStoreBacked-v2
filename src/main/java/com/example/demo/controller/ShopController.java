package com.example.demo.controller;

import com.example.demo.model.basket.Basket;
import com.example.demo.model.product.Product;
import com.example.demo.model.recipt.Receipt;
import com.example.demo.model.user.AppUser;
import com.example.demo.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

   private final ShopService shopService;

    @GetMapping("/receipt")
    public ResponseEntity<Receipt> getReceipt(@RequestParam(name = "basketId") Long basketId) {
      Receipt receipt = shopService.getReceipt(basketId);
      if (receipt == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(receipt);
    }


    @PostMapping("/product")
    public ResponseEntity<Basket> addProduct(@RequestParam(name = "basketId") Long basketId, @RequestParam(name = "name") String name) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/shop/product").toUriString());
        Basket basket = shopService.addProduct(basketId, name);
        if (basket == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.created(uri).body(basket);
    }

    @PostMapping("/basket")
    public ResponseEntity<Basket> removeProduct(@RequestParam(name = "basketId") Long basketId, @RequestParam(name = "name") String name) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/shop/product").toUriString());
        Basket basket = shopService.removeProduct(basketId, name);
        if (basket == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(basket);
    }

}
