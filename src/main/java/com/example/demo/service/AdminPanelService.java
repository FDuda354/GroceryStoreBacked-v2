package com.example.demo.service;

import com.example.demo.configuration.DbInit;
import com.example.demo.exception.ProductAlreadyExistException;
import com.example.demo.exception.ProductNotFoundInDBException;
import com.example.demo.model.product.Product;
import com.example.demo.model.user.AppUser;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminPanelService {

    private final AppUserService appUserService;

    private final UserRepo userRepo;
    private final ShopService shopService;
    private final ProductRepo productRepo;
    private final DbInit dbInit;



    public void reset() throws Exception {
        try {
            appUserService.deleteAllUsers();
            userRepo.deleteAll();
            productRepo.deleteAll();
            shopService.reset();
            dbInit.fillDB();
        } catch (Exception e) {
            log.error("Error while resetting database: " + e.getMessage());
            throw new Exception("Error while resetting database: " + e.getMessage());
        }
    }

    public Product addProductToDB(Product newProduct) throws Exception {
        try
        {
            var product = productRepo.findByName(newProduct.getName());
            if (product.isPresent()) {
                log.error("Product already exist in database");
                throw new ProductAlreadyExistException("Product already exist in database");
            }
            return productRepo.save(newProduct);
        } catch (Exception e) {
            log.error("Error while adding product to database: " + e.getMessage());
            throw new Exception("Error while adding product to database: " + e.getMessage());
        }

    }

    public void removeProductFromDB(String name) throws Exception {
        try {
            var product = productRepo.findByName(name);
            if (product.isEmpty()){
                log.error("Product not found in database");
                throw new ProductNotFoundInDBException("Product not found in database");
            }
            productRepo.deleteById(product.get().getId());
        } catch (Exception e) {
            log.error("Error while removing product from database: " + e.getMessage());
            throw new Exception("Error while removing product from database: " + e.getMessage());
        }

    }

    public void deleteAppUser(Long id) throws Exception {
        try {
            Optional<AppUser> appUser = userRepo.findById(id);
            if (appUser.isEmpty()) {
                log.error("User not found in database");
                throw new UsernameNotFoundException("User not found in database");
            }
            userRepo.deleteById(id);
        } catch (Exception e) {
            log.error("Error while deleting user from database: " + e.getMessage());
            throw new Exception("Error while deleting user from database: " + e.getMessage());
        }
    }

    public List<AppUser> getAllAppUsers() throws Exception {
        try
        {
            return userRepo.findAll();
        } catch (Exception e) {
            log.error("Error while getting all users from database: " + e.getMessage());
            throw new Exception("Error while getting all users from database: " + e.getMessage());
        }
    }
}
