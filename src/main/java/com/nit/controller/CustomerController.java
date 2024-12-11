package com.nit.controller;


import com.nit.model.Customer;
import com.nit.service.ICustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerServiceImpl customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer customer1 = customerService.createCustomer(customer);
        return new ResponseEntity<Customer>(customer1, HttpStatus.CREATED);
    }

    @GetMapping("{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @PutMapping("{customerId}")
    public ResponseEntity<?> updateCustomerById(@RequestBody Customer customer, @PathVariable String customerID) {
        customerService.UpdateCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity<?> deleteByCustomerById(@PathVariable String customerId) {
        customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>(customerId, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Customer>> getCustomerByLastName(@RequestParam String lastName) {
        List<Customer>customer=customerService.SearchCustomerByLastName(lastName);
        return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
    }
}
