package com.nit.entity;
import jakarta.persistence.*;


import lombok.Data;

@Data
@Entity
@Table(name = "account_balance")
public class AccountBalance {
    @Id
    @Column(name = "account_number", nullable = false)
    private String accountNumber;
    @Column(name = "balance", nullable = false)
    private Double balance;
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


}
