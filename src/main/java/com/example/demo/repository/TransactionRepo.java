package com.example.demo.repository;

import com.example.demo.model.payments.AppTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<AppTransaction, Long> {
}