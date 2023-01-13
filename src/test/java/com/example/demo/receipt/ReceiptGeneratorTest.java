package com.example.demo.receipt;

import com.example.demo.model.basket.Basket;
import com.example.demo.model.product.ProductDb;
import com.example.demo.model.recipt.ReceiptGenerator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReceiptGeneratorTest {

    @Test
    void shouldGenerateReceiptForGivenBasket() {
        // Given
        var productDb = new ProductDb();
        var cart = new Basket();
        var milk = productDb.getProduct("Milk");
        var bread = productDb.getProduct("Bread");
        var apple = productDb.getProduct("Apple");
        var expectedTotalPrice =
                milk.getPrice().multiply(BigDecimal.valueOf(2))
                .add(bread.getPrice())
                .add(apple.getPrice());

        cart.addProduct(milk);
        cart.addProduct(milk);
        cart.addProduct(bread);
        cart.addProduct(apple);

        var receiptGenerator = new ReceiptGenerator();

        // When
        var receipt = receiptGenerator.generate(cart);

        // Then
        assertNotNull(receipt);
        assertEquals(3, receipt.getEntries().size());
        assertEquals(expectedTotalPrice, receipt.getTotalPrice());
        assertEquals(0, receipt.getDiscounts().size());
    }

}
