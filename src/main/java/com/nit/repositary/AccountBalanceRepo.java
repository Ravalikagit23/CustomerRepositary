package com.nit.repositary;

import com.nit.entity.AccountBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountBalanceRepo extends JpaRepository<AccountBalance, Long> {


    Optional<AccountBalance> findByAccountNumber(String senderAccountNumber);






}
