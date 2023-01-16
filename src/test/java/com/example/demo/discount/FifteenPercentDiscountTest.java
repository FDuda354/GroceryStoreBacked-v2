package com.example.demo.discount;

import com.example.demo.model.payments.discount.FifteenPercentDiscount;
import com.example.demo.model.product.ProductDb;
import com.example.demo.model.recipt.Receipt;
import com.example.demo.model.recipt.ReceiptEntry;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FifteenPercentDiscountTest {

    @Test
    void shouldApply15PercentDiscountWhenBasketContains3ItemsOfTypeGrains() {
        // Given
        var productDb = new ProductDb();
        var cheese = productDb.getProduct("Cheese");
        var steak = productDb.getProduct("Steak");
        var bread = productDb.getProduct("Bread");
        var cereals = productDb.getProduct("Cereals");
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(cheese, 1L));
        receiptEntries.add(new ReceiptEntry(steak, 1L));
        receiptEntries.add(new ReceiptEntry(bread, 2L));
        receiptEntries.add(new ReceiptEntry(cereals, 1L));
        var discounts = new ArrayList<String>();
        var receipt = new Receipt(receiptEntries,discounts);

        var discount = new FifteenPercentDiscount();
        var expectedTotalPrice =
                        cheese.getPrice()
                        .add(steak.getPrice())
                        .add(bread.getPrice().multiply(BigDecimal.valueOf(2)))
                        .add(cereals.getPrice())
                        .multiply(BigDecimal.valueOf(0.85));

        // When
         discount.apply(receipt);

        // Then
        assertEquals(expectedTotalPrice, receipt.getTotalPrice());
        assertEquals(1, receipt.getDiscounts().size());
    }

    @Test
    void shouldNotApply15PercentDiscountWhenBasketContains3ItemsOfTypeDairy() {
        // Given
        var productDb = new ProductDb();
        var cheese = productDb.getProduct("Cheese");
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(cheese, 2L));
        var discounts = new ArrayList<String>();
        var receipt = new Receipt(receiptEntries,discounts);
        var discount = new FifteenPercentDiscount();
        var expectedTotalPrice = cheese.getPrice().multiply(BigDecimal.valueOf(2));

        // When
        discount.apply(receipt);

        // Then
        assertEquals(expectedTotalPrice, receipt.getTotalPrice());
        assertEquals(0, receipt.getDiscounts().size());
    }
}
