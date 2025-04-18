package com.nit.repositary;

import com.nit.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepo extends MongoRepository<Account,String> {
    Optional<Account> findByAccountNumber(String accountNumber);

    void deleteByAccountNumber(String accountNumber);
}