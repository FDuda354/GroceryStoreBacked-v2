package com.example.demo.discount;

import com.example.demo.model.payments.discount.TenPercentDiscount;
import com.example.demo.model.product.ProductDb;
import com.example.demo.model.recipt.Receipt;
import com.example.demo.model.recipt.ReceiptEntry;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TenPercentDiscountTest {

    @Test
    void shouldApply10PercentDiscountWhenPriceIsAbove50() {
        // Given
        var productDb = new ProductDb();
        var cheese = productDb.getProduct("Cheese");
        var steak = productDb.getProduct("Steak");
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(cheese, 1));
        receiptEntries.add(new ReceiptEntry(steak, 1));
        var discounts = new ArrayList<String>();
        var receipt = new Receipt(receiptEntries,discounts);

        var discount = new TenPercentDiscount();
        var expectedTotalPrice = cheese.getPrice().add(steak.getPrice()).multiply(BigDecimal.valueOf(0.9));

        // When
        discount.apply(receipt);

        // Then
        assertEquals(expectedTotalPrice, receipt.getTotalPrice());
        assertEquals(1, receipt.getDiscounts().size());
    }

    @Test
    void shouldNotApply10PercentDiscountWhenPriceIsBelow50() {
        // Given
        var productDb = new ProductDb();
        var cheese = productDb.getProduct("Cheese");
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(cheese, 2));
        var discounts = new ArrayList<String>();
        var receipt = new Receipt(receiptEntries,discounts);
        var discount = new TenPercentDiscount();
        var expectedTotalPrice = cheese.getPrice().multiply(BigDecimal.valueOf(2));

        // When
        discount.apply(receipt);

        // Then
        assertEquals(expectedTotalPrice, receipt.getTotalPrice());
        assertEquals(0, receipt.getDiscounts().size());
    }
}
