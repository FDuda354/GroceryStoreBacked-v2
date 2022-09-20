package com.example.demo.model.discount;

import com.example.demo.model.product.Product;
import com.example.demo.model.product.ProductType;
import com.example.demo.model.recipt.Receipt;

import java.math.BigDecimal;

public class FifteenPercentDiscount implements Discount {

    public static String NAME = "FifteenPercentDiscount";

    @Override
    public String description() {
        return NAME;
    }

    @Override
    public void apply(Receipt receipt) {
        if (shouldApply(receipt)) {
            var totalPrice = receipt.getTotalPrice().multiply(BigDecimal.valueOf(0.85));
            var discounts = receipt.getDiscounts();
            discounts.add(NAME);

            receipt.setTotalPrice(totalPrice);
            receipt.setDiscounts(discounts);
        }

    }

    @Override
    public boolean shouldApply(Receipt receipt) {

       int count = 0;

         for (var entry : receipt.getEntries()) {
              if (entry.product().getType().equals(ProductType.GRAINS)) {
                    count += entry.quantity();
              }

         }
         return count >= 3;
    }
}

