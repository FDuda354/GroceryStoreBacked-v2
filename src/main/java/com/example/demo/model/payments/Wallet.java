package com.example.demo.model.payments;

import com.example.demo.exception.OutOfMoneyException;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private BigDecimal balance;
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    @NonNull
    private List<AppTransaction> transactions;
    @NonNull
    private String owner;

    public void addMoney(BigDecimal amount, String description) {

        balance = balance.add(amount);
        transactions.add(new AppTransaction(amount, description, this, TransactionDirection.INCOME));
    }


    public void removeMoney(BigDecimal amount, String description) throws OutOfMoneyException {
        if(amount.compareTo(balance)>0)
            throw new OutOfMoneyException("Not enough money");
        balance = balance.subtract(amount);
        transactions.add(new AppTransaction(amount, description,this, TransactionDirection.OUTCOME));
    }

}