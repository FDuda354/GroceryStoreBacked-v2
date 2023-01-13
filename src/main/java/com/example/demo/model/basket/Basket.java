package com.example.demo.model.basket;

import com.example.demo.model.product.Product;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "baskets")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "purchased_products_baskets",
            joinColumns = @JoinColumn(name = "basked_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "purchased_products")
    private List<Product> products = new LinkedList<>();

    @NonNull
    private String owner;

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void removeAllProducts() {
        products.clear();
    }

}
