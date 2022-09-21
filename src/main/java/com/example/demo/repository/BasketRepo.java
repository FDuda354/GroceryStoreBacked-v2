package com.example.demo.repository;

import com.example.demo.model.basket.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepo extends JpaRepository<Basket, Long>
{
}
