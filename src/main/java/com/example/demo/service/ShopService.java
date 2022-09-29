package com.example.demo.service;

import com.example.demo.model.basket.Basket;
import com.example.demo.model.discount.Discount;
import com.example.demo.model.product.Product;
import com.example.demo.model.product.ProductType;
import com.example.demo.model.recipt.Receipt;
import com.example.demo.model.recipt.ReceiptGenerator;
import com.example.demo.repository.BasketRepo;
import com.example.demo.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@Transactional
@Slf4j
public class ShopService {

    private final ProductRepo productRepo;
    private final ReceiptGenerator receiptGenerator;
    private final BasketRepo basketRepo;

    @Autowired
    public ShopService(ProductRepo productRepo, ReceiptGenerator receiptGenerator,BasketRepo basketRepo) {
        this.receiptGenerator = receiptGenerator;
        this.basketRepo = basketRepo;
        this.productRepo = productRepo;
    }


    public Receipt getReceipt(Long basketId) {
        Receipt receipt = receiptGenerator.generate(basketRepo.findById(basketId).get());
        Discount.applyDiscounts(receipt);
        return receipt;
    }

    public Basket addProduct(Long basketId, String productName) {
        Basket basket = basketRepo.findById(basketId).get();
        Product product = productRepo.findByName(productName);
        basket.addProduct(product);
        return basketRepo.save(basket);
    }

    public void removeProduct(Long basketId, String name) {
        Basket basket = basketRepo.findById(basketId).get();
        Product product = productRepo.findByName(name);
        basket.removeProduct(product);
        basketRepo.save(basket);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDB() {
//        productRepo.save(new Product(1L,"Apple", ProductType.FRUITS, new BigDecimal(2)));
//        productRepo.save(new Product(2L,"Orange", ProductType.FRUITS, new BigDecimal(3)));
//        productRepo.save(new Product(3L,"Banana", ProductType.FRUITS, new BigDecimal("4.4")));
//        productRepo.save(new Product(4L,"Potato", ProductType.VEGETABLES, new BigDecimal("1.2")));
//        productRepo.save(new Product(5L,"Tomato", ProductType.VEGETABLES, new BigDecimal(7)));
//        productRepo.save(new Product(6L,"Onion", ProductType.VEGETABLES, new BigDecimal("1.7")));
//        productRepo.save(new Product(7L,"Milk", ProductType.DAIRY, new BigDecimal("2.7")));
//        productRepo.save(new Product(8L,"Cheese", ProductType.DAIRY, new BigDecimal("20.5")));
//        productRepo.save(new Product(9L,"Butter", ProductType.DAIRY, new BigDecimal(7)));
//        productRepo.save(new Product(10L,"Pork", ProductType.MEAT, new BigDecimal(16)));
//        productRepo.save(new Product(11L,"Steak", ProductType.MEAT, new BigDecimal(50)));
//        productRepo.save(new Product(12L,"Bread", ProductType.GRAINS, new BigDecimal(5)));
//        productRepo.save(new Product(13L,"Cereals", ProductType.GRAINS,new BigDecimal(8)));
//    }


}
