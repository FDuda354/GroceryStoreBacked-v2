package com.example.demo.model.product;

import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ProductDb {

    private final Set<Product> products;


    public ProductDb() {
        this.products = Stream.of(
                new Product(1L,"Apple", ProductType.FRUITS, new BigDecimal(2)),
                new Product(2L,"Orange", ProductType.FRUITS, new BigDecimal(5)),
                new Product(3L,"Banana", ProductType.FRUITS, new BigDecimal("4.4")),
                new Product(4L,"Potato", ProductType.VEGETABLES, new BigDecimal("1.2")),
                new Product(5L,"Tomato", ProductType.VEGETABLES, new BigDecimal(7)),
                new Product(6L,"Onion", ProductType.VEGETABLES, new BigDecimal("1.7")),
                new Product(7L,"Milk", ProductType.DAIRY, new BigDecimal("2.7")),
                new Product(8L,"Cheese", ProductType.DAIRY, new BigDecimal("20.5")),
                new Product(9L,"Butter", ProductType.DAIRY, new BigDecimal(7)),
                new Product(10L,"Pork", ProductType.MEAT, new BigDecimal(16)),
                new Product(11L,"Steak", ProductType.MEAT, new BigDecimal(50)),
                new Product(12L,"Bread", ProductType.GRAINS, new BigDecimal(5)),
                new Product(13L,"Cereals", ProductType.GRAINS,new BigDecimal(8))
        ).collect(Collectors.toSet());
    }

    public Product getProduct(String productName) {
        return products.stream()
                .filter(product -> productName.equals(product.getName()))
                .findFirst()
                .get();
    }

    public Set<Product> getProducts() {
        return products;
    }

}

