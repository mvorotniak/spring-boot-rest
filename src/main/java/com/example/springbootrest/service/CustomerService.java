package com.example.springbootrest.service;

import java.util.List;

import com.example.springbootrest.domain.Customer;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer saveCustomer(Customer customer);

}
