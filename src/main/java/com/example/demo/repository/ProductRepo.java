package com.example.demo.repository;

import com.example.demo.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Product findByName(String name);

}

