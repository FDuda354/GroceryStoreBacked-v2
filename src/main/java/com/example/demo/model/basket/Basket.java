package com.example.demo.model.basket;

import com.example.demo.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "baskets")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.PERSIST, fetch = EAGER, orphanRemoval = true)
    @NonNull
    private List<BasketProduct> basketProducts;

    @NonNull
    private String owner;


    public BasketProduct addProduct(Product product) {
        BasketProduct basketProduct = basketProducts.stream()
                .filter(bp -> bp.getProduct().equals(product))
                .findFirst()
                .orElse(null);

        if (basketProduct != null) {
            basketProduct.setQuantity(basketProduct.getQuantity() + 1L);
        } else {
            basketProduct = new BasketProduct( this,product, 1L);
            basketProducts.add(basketProduct);

        }
        return basketProduct;
    }

    @JsonIgnore
    public List<Product> getProducts() {
        return basketProducts.stream()
                .map(BasketProduct::getProduct)
                .collect(Collectors.toList());
    }


    public void removeProduct(Product product) {
        basketProducts.removeIf(bp -> bp.getProduct().equals(product));
    }


    public void removeAllProducts() {
        basketProducts.clear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BasketProduct> getBasketProducts() {
        return basketProducts;
    }

    public void setBasketProducts(List<BasketProduct> basketProducts) {
        this.basketProducts = basketProducts;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
