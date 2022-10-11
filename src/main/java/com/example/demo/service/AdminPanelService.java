package com.example.demo.service;

import com.example.demo.model.product.Product;
import com.example.demo.model.user.AppUser;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminPanelService {

    private final AppUserService appUserService;

    private final UserRepo userRepo;
    private final ShopService shopService;
    private final ProductRepo productRepo;


    public void reset() {
        appUserService.deleteAllAppUsers();
        shopService.reset();

    }

    public Product addProductToDB(Product product) {
       return productRepo.save(product);
    }

    public void removeProductFromDB(String name) {
        productRepo.deleteById(productRepo.findByName(name).getId());
    }

    public void deleteAppUser(Long id) {
        if(userRepo.existsById(id)) {
            AppUser appUser = userRepo.findById(id).get();
            userRepo.deleteById(id);
            log.info("User {} deleted", appUser.getUsername());
        }
        else {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }
    }

    public List<AppUser> getAllAppUsers() {
        return userRepo.findAll();
    }
}
