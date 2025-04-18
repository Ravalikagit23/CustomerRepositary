package com.nit.controller;

import com.nit.entity.Account;
import com.nit.entity.Customer;
import com.nit.service.AccountBalanceService;
import com.nit.service.AccountServiceImpl;
import com.nit.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private AccountBalanceService accountBalService;

    @PostMapping()
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account account1 = accountService.createAccount(account);//123
        List<String> customerId = account.getCustomerId();
        Customer customer = customerService.getCustomerById(customerId.get(0));
        List<String> listOfAccounts = new ArrayList<>();
        String accountNumber = account.getAccountNumber();
        listOfAccounts.add(accountNumber);
        customer.setAccounts(listOfAccounts);
        customerService.UpdateCustomer(customer);
        accountBalService.updateAccountBalance(accountNumber, 0.0);
        //Reterive customer by customer id from mongo
        // In customer object add account id//123                                                  
        //Save customer objects to mongo db
        //Insert new record in account_balance table
        return new ResponseEntity<Account>(account1, HttpStatus.CREATED);
    }
    @GetMapping("{accountNumber}")
    public ResponseEntity<Account> getAccountByNumber(@PathVariable String accountNumber) {
        Account account = accountService.getAccountByNumber(accountNumber);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
    }

    @DeleteMapping("{accountNumber}")
    public ResponseEntity<?> deleteByAccountNumber(@PathVariable String accountNumber) {
        accountService.deleteAccountByNumber(accountNumber);
        return new ResponseEntity<>(accountNumber, HttpStatus.OK);
    }

    @PutMapping("{accountNumber}")
    public ResponseEntity<Account> updateByAccountNumber(@RequestBody Account account, @PathVariable String accountNumber) {
        Account account1 = accountService.UpdateAccount(accountNumber, account);
        return new ResponseEntity<Account>(account1, HttpStatus.OK);
    }


}
