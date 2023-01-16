package com.example.demo.model.recipt;

import com.example.demo.model.product.Product;

import java.math.BigDecimal;


public record ReceiptEntry(

        Product product,
        Long quantity,
        BigDecimal totalPrice) {

    public ReceiptEntry(Product product, Long quantity) {
        this(product, quantity, product.getPrice().multiply(BigDecimal.valueOf(quantity)));
    }

}
