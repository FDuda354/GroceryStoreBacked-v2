package com.example.demo.model.recipt;

import com.example.demo.model.basket.Basket;
import com.example.demo.model.product.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ReceiptGenerator {

    public Receipt generate(Basket basket) {

        List<String> discounts = new ArrayList<>();
        List<ReceiptEntry> receiptEntries = new ArrayList<>();

        HashMap<Product, Integer> products = new HashMap<>();

        for (Product product : basket.getProducts()) {
            products.merge(product, 1, Integer::sum);
        }

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            receiptEntries.add(new ReceiptEntry(entry.getKey(), entry.getValue()));
        }



        return new Receipt(receiptEntries,discounts);
    }

}
