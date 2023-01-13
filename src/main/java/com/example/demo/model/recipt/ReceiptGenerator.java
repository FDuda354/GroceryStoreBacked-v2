package com.example.demo.model.recipt;

import com.example.demo.model.basket.Basket;
import com.example.demo.model.product.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ReceiptGenerator {

    public Receipt generate(Basket basket) {

        List<String> discounts = new ArrayList<>();
        List<ReceiptEntry> receiptEntries = new ArrayList<>();

        basket.getProducts().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((product, count) -> receiptEntries.add(new ReceiptEntry(product, count.intValue())));

        return new Receipt(receiptEntries, discounts);
    }

}
