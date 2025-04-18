package com.nit.repositary;

import com.nit.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends MongoRepository<Customer,String> {


    public List<Customer> findByLastName(String lastName);

    Optional<Customer> findByCustomerId(String customerId);
    public void deleteByCustomerId(String customerId);
}
