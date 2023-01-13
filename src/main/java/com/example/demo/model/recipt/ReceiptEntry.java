package com.example.demo.model.recipt;

import com.example.demo.model.product.Product;

import java.math.BigDecimal;


public record ReceiptEntry(

        Product product,
        int quantity,
        BigDecimal totalPrice) {

    public ReceiptEntry(Product product, int quantity) {
        this(product, quantity, product.getPrice().multiply(BigDecimal.valueOf(quantity)));
    }
}
