package com.nit.service;

import com.nit.model.TransferMoneyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferMoneyService {

    @Autowired
    private AccountBalanceService balanceService;

@Transactional
    public String transferTheMoney(TransferMoneyRequest request) {
        balanceService.withDrawAmountFromAccount(request.getSenderAccountNumber(), request.getAmount());
         balanceService.creditAmountToAccount(request.getReceiverAccountNumber(), request.getAmount());
         return "Amount Transferred from Account is Successful";
    }
}
