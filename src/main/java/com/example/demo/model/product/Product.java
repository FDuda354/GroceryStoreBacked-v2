package com.example.demo.model.product;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name = "products")
public class Product{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        @Column(name="name")
        @NonNull
       String name;
        @Column(name="type")
        @NonNull
        ProductType type;
        @Column(name="price")
        @NonNull
        BigDecimal price;



}