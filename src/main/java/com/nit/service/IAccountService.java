package com.nit.service;

import com.nit.entity.Account;

import java.util.List;

public interface IAccountService {
    public Account createAccount(Account account);
    public Account getAccountByNumber(String accountNumber);
    public List<Account> getAllAccounts();
    public void deleteAccountByNumber(String accountNumber);
    public Account UpdateAccount(String accountNumber,Account updateAccount);

}
