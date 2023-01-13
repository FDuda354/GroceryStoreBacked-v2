package com.example.demo.configuration;

import com.example.demo.model.basket.Basket;
import com.example.demo.model.product.Product;
import com.example.demo.model.product.ProductType;
import com.example.demo.model.user.AppUser;
import com.example.demo.model.user.Role;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class DbInit {
    private final ProductRepo productRepo;
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {

        List<Product> products;
        products = Stream.of(
                new Product(1L,"Apple", ProductType.FRUITS, new BigDecimal(2)),
                new Product(2L,"Orange", ProductType.FRUITS, new BigDecimal(5)),
                new Product(3L,"Banana", ProductType.FRUITS, new BigDecimal("4.4")),
                new Product(4L,"Potato", ProductType.VEGETABLES, new BigDecimal("1.2")),
                new Product(5L,"Tomato", ProductType.VEGETABLES, new BigDecimal(7)),
                new Product(6L,"Onion", ProductType.VEGETABLES, new BigDecimal("1.7")),
                new Product(7L,"Milk", ProductType.DAIRY, new BigDecimal("2.7")),
                new Product(8L,"Cheese", ProductType.DAIRY, new BigDecimal("20.5")),
                new Product(9L,"Butter", ProductType.DAIRY, new BigDecimal(7)),
                new Product(10L,"Pork", ProductType.MEAT, new BigDecimal(16)),
                new Product(11L,"Steak", ProductType.MEAT, new BigDecimal(50)),
                new Product(12L,"Bread", ProductType.GRAINS, new BigDecimal(5)),
                new Product(13L,"Cereals", ProductType.GRAINS,new BigDecimal(8))
        ).collect(Collectors.toList());

        productRepo.saveAll(products);

        userRepo.save(AppUser.builder()
                .username("filip")
                .password(passwordEncoder.encode("1234"))
                .email("filipduda9@wp.pl")
                .role("ROLE_"+ Role.ADMIN)
                .basket(new Basket("filip"))
                .build());
    }


}
