package com.nit.service;

import com.nit.entity.AccountBalance;
import com.nit.model.UpdateAccountRequest;
import com.nit.repositary.AccountBalanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountBalanceService {

    @Autowired
    private AccountBalanceRepo accountBalRepo;

    @Transactional
    public UpdateAccountRequest updateAccountBalance(String accountNumber, Double balance) {
        Optional<AccountBalance> account = accountBalRepo.findByAccountNumber(accountNumber);
        if (account.isPresent()) {
            AccountBalance updatedBal = account.get();
            updatedBal.setBalance(balance);
            accountBalRepo.save(updatedBal);
        } else {
            AccountBalance accountBalance = new AccountBalance();
            accountBalance.setAccountNumber(accountNumber);
            accountBalance.setBalance(balance);
            accountBalRepo.save(accountBalance);
        }
        return null;
    }
public void  withDrawAmountFromAccount(String senderAccountNumber,double amount) {
    Optional<AccountBalance> account = accountBalRepo.findByAccountNumber(senderAccountNumber);
    if (account.isPresent()) {
        AccountBalance accountBalance = account.get();
        double updatedAmount = accountBalance.getBalance() - amount;
        accountBalance.setBalance(updatedAmount);
        accountBalRepo.save(accountBalance);
    }
}
    public void  creditAmountToAccount(String receiverAccountNumber,double amount){
        Optional<AccountBalance> account = accountBalRepo.findByAccountNumber(receiverAccountNumber);
        if (account.isPresent()) {
            AccountBalance accountBalance = account.get();
            double updatedAmount = accountBalance.getBalance() + amount;
            accountBalance.setBalance(updatedAmount);
            accountBalRepo.save(accountBalance);
        }

    }
    public Optional<AccountBalance> getBalByAccountNumber(String accountNumber) {
        return accountBalRepo.findByAccountNumber(accountNumber);
    }
}
