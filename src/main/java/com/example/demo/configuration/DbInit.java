package com.example.demo.configuration;

import com.example.demo.model.basket.Basket;
import com.example.demo.model.payments.Wallet;
import com.example.demo.model.product.Product;
import com.example.demo.model.product.ProductType;
import com.example.demo.model.user.AppUser;
import com.example.demo.model.user.Role;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.TransactionRepo;
import com.example.demo.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class DbInit {
    private final ProductRepo productRepo;
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    private final TransactionRepo transRepo;

    //@EventListener(ApplicationReadyEvent.class)
    public void fillDB() throws Exception {

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

        AppUser user = AppUser.builder()
                .username("filip")
                .password(passwordEncoder.encode("1234"))
                .email("filipduda9@wp.pl")
                .role("ROLE_"+ Role.ADMIN)
                .basket(new Basket("filip"))
                .wallet(Wallet.builder()
                        .balance(new BigDecimal(500))
                        .owner("filip")
                        .transactions(new ArrayList<>())
                        .build())
                .build();

        user.getWallet().addMoney(new BigDecimal(100),"First money");
        user.getWallet().addMoney(new BigDecimal(100),"Second money");
        user.getWallet().addMoney(new BigDecimal(100),"Third money");
        user.getWallet().removeMoney(new BigDecimal(100),"pay for apple");

        userRepo.save(user);

    }


}
