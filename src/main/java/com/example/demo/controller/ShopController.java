package com.example.demo.controller;

import com.example.demo.exception.*;
import com.example.demo.model.basket.Basket;
import com.example.demo.model.recipt.Receipt;
import com.example.demo.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/receipt")
    public ResponseEntity<Receipt> getReceipt(@RequestParam(name = "userId") Long userId) {
        try {
            return ResponseEntity.ok().body(shopService.getReceipt(userId));
        } catch (UserNotFoundInDBException e) {
            return ResponseEntity.notFound().build();
        }catch (OutOfMoneyException e) {
            return ResponseEntity.status(402).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/product")
    public ResponseEntity<Basket> addProduct(@RequestParam(name = "basketId") Long basketId, @RequestParam(name = "name") String name) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/shop/product").toUriString());
            return ResponseEntity.created(uri).body(shopService.addProduct(basketId, name));
        } catch (BasketNotFoundInDBException | ProductNotFoundInDBException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/basket")
    public ResponseEntity<Basket> removeProduct(@RequestParam(name = "basketId") Long basketId, @RequestParam(name = "productName") String productName) {
        try {
            return ResponseEntity.ok().body(shopService.removeProduct(basketId, productName));
        } catch (BasketNotFoundInDBException | ProductNotFoundInBasketException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
