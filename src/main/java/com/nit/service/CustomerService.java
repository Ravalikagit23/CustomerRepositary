package com.nit.service;

import com.nit.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public Customer getCustomerById(String customerId);
    public List<Customer> getAllCustomers();
    public void deleteCustomerById(String customerId);
    public void UpdateCustomer(Customer customer);
    public List<Customer>SearchCustomerByLastName(String lastName);


}
