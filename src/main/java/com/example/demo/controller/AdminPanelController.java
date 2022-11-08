package com.example.demo.controller;


import com.example.demo.model.product.Product;
import com.example.demo.model.user.AppUser;
import com.example.demo.service.AdminPanelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@CrossOrigin(origins = "https://grocerystore-fduda354.koyeb.app/api")
public class AdminPanelController {

    private final AdminPanelService adminPanelService;

    @GetMapping("/all")
    public ResponseEntity<List<AppUser>>getAllAppUsers(){
        return ResponseEntity.ok().body(adminPanelService.getAllAppUsers());
    }

    @PostMapping("/product")
    public Product addProductToDB(@RequestBody Product product) {
        return adminPanelService.addProductToDB(product);
    }

    @DeleteMapping("/reset")
    public void reset() {
        adminPanelService.reset();
    }

    @DeleteMapping("/product")
    public void removeProductFromDB(@RequestParam(name = "name") String name) {
        adminPanelService.removeProductFromDB(name);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAppUser(@RequestParam(name = "id") Long id){
        this.adminPanelService.deleteAppUser(id);
        return ResponseEntity.noContent().build();
    }
}
