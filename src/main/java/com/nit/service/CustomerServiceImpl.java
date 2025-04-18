package com.nit.service;

import com.nit.entity.Customer;
import com.nit.repositary.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public Customer createCustomer(Customer customer) {
       return  customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(String customerId) {
      Optional <Customer >customerOptional=customerRepo.findByCustomerId(customerId);

      return customerOptional.orElseThrow(()-> new IllegalArgumentException("Customer With Id"
                +customerId+"was Not found"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public void deleteByCustomerId(String customerId) {

        customerRepo.deleteByCustomerId(customerId);
    }

    @Override
    public void UpdateCustomer(Customer customer) {

        customerRepo.save(customer);
    }

    @Override
    public List<Customer> SearchCustomerByLastName(String lastName) {
        return customerRepo.findByLastName(lastName);
    }
}
