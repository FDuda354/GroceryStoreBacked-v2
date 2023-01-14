package com.example.demo.service;

import com.example.demo.exception.BasketNotFoundInDBException;
import com.example.demo.exception.OutOfMoneyException;
import com.example.demo.exception.ProductNotFoundInBasketException;
import com.example.demo.exception.ProductNotFoundInDBException;
import com.example.demo.model.basket.Basket;
import com.example.demo.model.payments.discount.Discount;
import com.example.demo.model.product.Product;
import com.example.demo.model.recipt.Receipt;
import com.example.demo.model.recipt.ReceiptGenerator;
import com.example.demo.model.user.AppUser;
import com.example.demo.repository.BasketRepo;
import com.example.demo.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ShopService {

    private final ProductRepo productRepo;
    private final ReceiptGenerator receiptGenerator;
    private final BasketRepo basketRepo;
    private final AppUserService appUserService;

    public Receipt getReceipt(Long userId) throws Exception {
        try {
            AppUser user = appUserService.getAppUserById(userId);
            Basket basket = user.getBasket();
            Receipt receipt = receiptGenerator.generate(basket);
            Discount.applyDiscounts(receipt);
            appUserService.payForProducts(receipt, user.getWallet(), basket);
            return receipt;
        } catch (OutOfMoneyException e) {
            log.error("User don't have enough money to pay for products");
            throw new OutOfMoneyException("User don't have enough money to pay for products");
        } catch (Exception e) {
            log.error("Error while generating receipt", e);
            throw new Exception("Error while generating receipt");
        }
    }

    public Basket addProduct(Long basketId, String productName) throws Exception {
        Basket basket = basketRepo.findById(basketId).orElseThrow(() -> {
            log.error("Basket with id {} not found", basketId);
            throw new BasketNotFoundInDBException("Basket with id " + basketId + " not found");
        });
        Product product = productRepo.findByName(productName).orElseThrow(() -> {
            log.error("Product with name {} not found", productName);
            throw new ProductNotFoundInDBException("Product with name " + productName + " not found");
        });
        try {
            basket.addProduct(product);
            return basketRepo.save(basket);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }

    }

    public Basket removeProduct(Long basketId, String productName) {
        Basket basket = basketRepo.findById(basketId).orElseThrow(() -> {
            log.error("Basket with id {} not found", basketId);
            throw new BasketNotFoundInDBException("Basket with id " + basketId + " not found");
        });
        Product product = productRepo.findByName(productName).orElseThrow(() -> {
            log.error("Product with name {} not found", productName);
            throw new ProductNotFoundInDBException("Product with name " + productName + " not found");
        });

        if (basket.getProducts().contains(product)) {
            basket.removeProduct(product);
            return basketRepo.save(basket);
        } else {
            log.error("Product not found in basket");
            throw new ProductNotFoundInBasketException("Product not found in basket");
        }
    }

    public Basket clearBasket(Basket basket) {
        basket.removeAllProducts();
        return basketRepo.save(basket);
    }

    public void reset() {
        basketRepo.deleteAll();
    }

}