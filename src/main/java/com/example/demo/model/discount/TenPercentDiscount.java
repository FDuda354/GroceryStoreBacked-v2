package com.example.demo.model.discount;

import com.example.demo.model.recipt.Receipt;

import java.math.BigDecimal;

public class TenPercentDiscount implements Discount {

    public static String NAME = "TenPercentDiscount";

    @Override
    public String description() {
        return NAME;
    }

    @Override
    public void apply(Receipt receipt) {
        if (shouldApply(receipt)) {
            var totalPrice = receipt.getTotalPrice().multiply(BigDecimal.valueOf(0.9));
            var discounts = receipt.getDiscounts();
            discounts.add(NAME);
            receipt.setTotalPrice(totalPrice);
            receipt.setDiscounts(discounts);
        }

    }

    @Override
    public boolean shouldApply(Receipt receipt) {
        return receipt.getTotalPrice().compareTo(BigDecimal.valueOf(50)) >= 0;
    }
}