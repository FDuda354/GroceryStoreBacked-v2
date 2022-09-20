package com.example.demo.model.recipt;

import com.example.demo.model.product.Product;
import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;


public record ReceiptEntry(

        Product product,
        int quantity,
        BigDecimal totalPrice) {

    public ReceiptEntry(Product product, int quantity) {
        this(product, quantity, product.getPrice().multiply(BigDecimal.valueOf(quantity)));
    }
}
