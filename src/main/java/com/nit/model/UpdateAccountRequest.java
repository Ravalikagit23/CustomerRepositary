package com.nit.model;

import jakarta.persistence.*;
import lombok.Data;


public class UpdateAccountRequest {

    private String accountNumber;
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


