package com.example.demo.repository;

import com.example.demo.model.basket.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketProductRepo extends JpaRepository<BasketProduct, Long> {

    void removeByBasketIdAndProductId(Long basketId, Long id);

    void removeByBasketId(Long id);
}
