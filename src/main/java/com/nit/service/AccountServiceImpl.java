package com.nit.service;

import com.nit.entity.Account;
import com.nit.repositary.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class AccountServiceImpl implements IAccountService{

@Autowired
private AccountRepo accountRepo;

    @Override
    public Account createAccount(Account account) {
       return  accountRepo.save(account);
    }

    @Override
    public Account getAccountByNumber(String accountNumber) {
        Optional<Account> accountOptional= accountRepo.findByAccountNumber(accountNumber);

        return accountOptional.orElseThrow(()-> new IllegalArgumentException("Account With Number"
                +accountNumber+"was Not found"));
    }

    @Override
    public List<Account> getAllAccounts() {

        return  accountRepo.findAll();
    }

    @Override
    public void deleteAccountByNumber(String accountNumber) {
  accountRepo.deleteByAccountNumber(accountNumber);
    }

    @Override
    public Account UpdateAccount(String accountNumber, Account updateAccount) {
        return accountRepo.save(updateAccount);
    }
}
