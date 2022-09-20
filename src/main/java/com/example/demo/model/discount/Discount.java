package com.example.demo.model.discount;

import com.example.demo.model.recipt.Receipt;

public interface Discount {


     boolean shouldApply(Receipt receipt);

     String description();

     void apply(Receipt receipt);

      Discount[] discounts = new Discount[] {
            new TenPercentDiscount(),
            new FifteenPercentDiscount()
    };

     static Discount[] getDiscounts() {
        return discounts;
    }

     static void applyDiscounts(Receipt receipt) {
        for (var discount : getDiscounts()) {
            discount.apply(receipt);
        }
    }

}
