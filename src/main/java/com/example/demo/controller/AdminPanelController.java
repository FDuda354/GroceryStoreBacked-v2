package com.example.demo.controller;


import com.example.demo.exception.ProductAlreadyExistException;
import com.example.demo.exception.ProductNotFoundInDBException;
import com.example.demo.exception.UserNotFoundInDBException;
import com.example.demo.model.product.Product;
import com.example.demo.model.user.AppUser;
import com.example.demo.service.AdminPanelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminPanelController {

    private final AdminPanelService adminPanelService;

    @GetMapping("/all")
    public ResponseEntity<List<AppUser>> getAllAppUsers() {
        try {
            return ResponseEntity.ok().body(adminPanelService.getAllAppUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProductToDB(@RequestBody Product product) {
        try {
            return ResponseEntity.ok().body(adminPanelService.addProductToDB(product));
        } catch (ProductAlreadyExistException e) {
            return ResponseEntity.status(409).build();
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProductInDB(@RequestBody Product product) {
        try {
            return ResponseEntity.ok().body(adminPanelService.updateProductInDB(product));
        } catch (ProductNotFoundInDBException e) {
            return ResponseEntity.status(404).build();
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/reset")
    public void reset() {
        try {
            adminPanelService.reset();
        } catch (Exception e) {
            ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/product")
    public ResponseEntity<?> removeProductFromDB(@RequestParam(name = "productName") String productName) {
        try {
            adminPanelService.removeProductFromDB(productName);
            return ResponseEntity.noContent().build();
        } catch (ProductNotFoundInDBException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAppUser(@RequestParam(name = "id") Long id) {
        try {
            adminPanelService.deleteAppUser(id);
            return ResponseEntity.noContent().build();
        } catch (UserNotFoundInDBException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
