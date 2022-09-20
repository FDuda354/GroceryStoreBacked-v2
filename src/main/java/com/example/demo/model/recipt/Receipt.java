package com.example.demo.model.recipt;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
public class Receipt
{
        List<ReceiptEntry> entries;
        List<String> discounts;
        BigDecimal totalPrice;
        LocalDate date;

    public Receipt(List<ReceiptEntry> entries,List<String> discounts) {
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

}