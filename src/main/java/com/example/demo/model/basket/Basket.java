package com.example.demo.model.basket;

import com.example.demo.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BASKETS")
@Component
public class Basket {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @ManyToMany(fetch = EAGER)
    @JoinTable(name="PURCHASED_PRODUCTS_BASKETS",
            joinColumns = @JoinColumn(name="basked_id"),
            inverseJoinColumns = @JoinColumn(name="product_id"))
    @Column(name="PURCHASED_PRODUCTS")
    private List<Product> products = new ArrayList<>();

    @Column(name="owner")
    private String owner;

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
