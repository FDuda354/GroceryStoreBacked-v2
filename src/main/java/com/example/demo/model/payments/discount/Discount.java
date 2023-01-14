package com.example.demo.model.payments.discount;

import com.example.demo.model.recipt.Receipt;

import java.util.Arrays;

public interface Discount {
    boolean shouldApply(Receipt receipt);

    String description();

    void apply(Receipt receipt);

    Discount[] discounts = new Discount[]{
            new TenPercentDiscount(),
            new FifteenPercentDiscount()
    };

    static Discount[] getDiscounts() {
        return discounts;
    }

    static void applyDiscounts(Receipt receipt) {
        Arrays.stream(discounts)
                .filter(discount -> discount.shouldApply(receipt))
                .forEach(discount -> discount.apply(receipt));
    }

}
