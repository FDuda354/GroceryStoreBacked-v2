package com.example.demo.model.payments;

import com.example.demo.exception.OutOfMoneyException;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    private List<AppTransaction> transactions;
    private String owner;

    public Wallet(Long id, BigDecimal balance, List<AppTransaction> transactions, String owner) {
        this.id = id;
        this.balance = balance;
        this.transactions = transactions;
        this.owner = owner;
    }

    public Wallet() {
    }

    public void addMoney(BigDecimal amount, String description) {

        balance = balance.add(amount);
        transactions.add(new AppTransaction(amount, description, this, TransactionDirection.INCOME));
    }


    public void removeMoney(BigDecimal amount, String description) throws Exception {
        if(amount.compareTo(balance)>0)
            throw new OutOfMoneyException("Not enough money");
        balance = balance.subtract(amount);
        transactions.add(new AppTransaction(amount, description,this, TransactionDirection.OUTCOME));
    }

}