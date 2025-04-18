package com.nit.controller;

import com.nit.entity.AccountBalance;
import com.nit.model.TransferMoneyRequest;
import com.nit.model.UpdateAccountRequest;
import com.nit.service.AccountBalanceService;
import com.nit.service.TransferMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account-balance")
public class AccountBalanceController {

    @Autowired
    private AccountBalanceService accountService;
    @Autowired
    private TransferMoneyService transferMoneyService;

    @PutMapping()
    public ResponseEntity<?> updateAccountBalance(@RequestBody UpdateAccountRequest accountBal) {
        String accountNumber = accountBal.getAccountNumber().trim();
        UpdateAccountRequest accountBalance = accountService.updateAccountBalance(accountNumber, accountBal.getBalance());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> trasferTheMoneyFromAccount(@RequestBody TransferMoneyRequest request){
       String  moneyRequest= transferMoneyService.transferTheMoney(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountBalance> getAccountBalance(@PathVariable String accountNumber) {
        Optional<AccountBalance> accountBalanceOptional = accountService.getBalByAccountNumber(accountNumber);
        if (accountBalanceOptional.isPresent()) {
            AccountBalance balance = accountBalanceOptional.get();
            return new ResponseEntity<>(balance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


