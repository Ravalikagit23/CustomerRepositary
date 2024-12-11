package com.nit.repositary;

import com.nit.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepo extends MongoRepository<Customer,String> {


     public List<Customer> findByLastName(String lastName);
}
