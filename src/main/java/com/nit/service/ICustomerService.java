package com.nit.service;

import com.nit.entity.Customer;

import java.util.List;

public interface ICustomerService {
    public Customer createCustomer(Customer customer);
    public Customer getCustomerById(String customerId);
    public List<Customer> getAllCustomers();
    public void deleteByCustomerId(String customerId);
    public void UpdateCustomer(Customer customer);
    public List<Customer>SearchCustomerByLastName(String lastName);


}
