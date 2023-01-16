package com.example.demo.model.payments;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "user_transactions")
public class AppTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private BigDecimal amount;
    @NonNull
    private String description;
    @ManyToOne
    @NonNull
    private Wallet wallet;
    @NonNull
    @Enumerated(EnumType.STRING)
    private TransactionDirection direction;


}