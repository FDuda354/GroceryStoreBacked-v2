package com.example.demo.discount;

import com.example.demo.model.discount.Discount;
import com.example.demo.model.product.ProductDb;
import com.example.demo.model.recipt.Receipt;
import com.example.demo.model.recipt.ReceiptEntry;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FifteenAndTenPercentDiscountTest {

    @Test
    void shouldApply15And10PercentDiscountWhenBasketContains3ItemsOfTypeGrains() {
        // Given
        var productDb = new ProductDb();
        var cheese = productDb.getProduct("Cheese");
        var steak = productDb.getProduct("Steak");
        var bread = productDb.getProduct("Bread");
        var cereals = productDb.getProduct("Cereals");
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(cheese, 1));
        receiptEntries.add(new ReceiptEntry(steak, 1));
        receiptEntries.add(new ReceiptEntry(bread, 5));
        receiptEntries.add(new ReceiptEntry(cereals, 1));
        var discounts = new ArrayList<String>();
        var receipt = new Receipt(receiptEntries,discounts);

        var expectedTotalPrice =
                cheese.getPrice()
                        .add(steak.getPrice())
                        .add(bread.getPrice().multiply(BigDecimal.valueOf(5)))
                        .add(cereals.getPrice())
                        .multiply(BigDecimal.valueOf(0.85)
                        .multiply(BigDecimal.valueOf(0.90)));

        // When
        Discount.applyDiscounts(receipt);

        // Then
        assertEquals(expectedTotalPrice, receipt.getTotalPrice());
        assertEquals(2, receipt.getDiscounts().size());
    }

    @Test
    void shouldNotApply15And10PercentDiscountWhenBasketContains3ItemsOfTypeDairy() {
        // Given
        var productDb = new ProductDb();
        var cheese = productDb.getProduct("Cheese");
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(cheese, 2));
        var discounts = new ArrayList<String>();
        var receipt = new Receipt(receiptEntries,discounts);
        var expectedTotalPrice = cheese.getPrice().multiply(BigDecimal.valueOf(2));

        // When
        Discount.applyDiscounts(receipt);

        // Then
        assertEquals(expectedTotalPrice, receipt.getTotalPrice());
        assertEquals(0, receipt.getDiscounts().size());
    }
}
