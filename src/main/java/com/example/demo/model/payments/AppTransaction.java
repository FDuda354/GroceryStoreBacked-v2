package com.example.demo.model.payments;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @NonNull
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    @JsonIgnore
    private Wallet wallet;
    @NonNull
    @Enumerated(EnumType.STRING)
    private TransactionDirection direction;


}