package com.example.demo.model.product;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
@Table(name = "products_db")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    String name;

    @NonNull
    @Enumerated(EnumType.STRING)
    ProductType type;

    @NonNull
    BigDecimal price;

}