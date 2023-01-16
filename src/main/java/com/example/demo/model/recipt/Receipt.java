package com.example.demo.model.recipt;

import com.example.demo.model.product.Product;
import com.example.demo.model.product.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class Receipt {
    List<ReceiptEntry> entries;
    List<String> discounts;
    BigDecimal totalPrice;
    LocalDate date;

    public Receipt(List<ReceiptEntry> entries, List<String> discounts) {
        this(entries, discounts,
                entries.stream()
                        .map(ReceiptEntry::totalPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add));

    }

    public Receipt(List<ReceiptEntry> entries, List<String> discounts, BigDecimal totalPrice) {
        this.entries = entries;
        this.discounts = discounts;
        this.totalPrice = totalPrice;
        this.date = LocalDate.now();
    }

    @JsonIgnore
    public String getTypeOfProduct() {
        return entries.stream()
                .map(ReceiptEntry::product)
                .map(Product::getType)
                .map(ProductType::name)
                .distinct()
                .collect(Collectors.joining(", "));
    }

}