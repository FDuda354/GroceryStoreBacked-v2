package com.example.demo.repository;


import com.example.demo.model.payments.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepo extends JpaRepository<Wallet, Long> {
}
