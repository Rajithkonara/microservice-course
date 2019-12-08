package com.rajithk.rentcloud.profileservice.service;

import com.rajithk.rentcloud.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    Customer getCustomerById(int id);

    List<Customer> getCustomers();

    List<Customer> getCustomerByName(String name);
}
