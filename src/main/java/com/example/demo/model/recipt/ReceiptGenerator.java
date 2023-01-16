package com.example.demo.model.recipt;

import com.example.demo.model.basket.Basket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReceiptGenerator {

    public Receipt generate(Basket basket) {

        List<String> discounts = new ArrayList<>();
        List<ReceiptEntry> receiptEntries = new ArrayList<>();

        basket.getBasketProducts().forEach(basketProduct -> {
            receiptEntries.add(new ReceiptEntry(basketProduct.getProduct(), basketProduct.getQuantity()));
        });

        return new Receipt(receiptEntries, discounts);
    }

}
