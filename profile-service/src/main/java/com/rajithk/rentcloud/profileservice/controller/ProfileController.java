package com.rajithk.rentcloud.profileservice.controller;

import com.rajithk.rentcloud.model.Customer;
import com.rajithk.rentcloud.profileservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {

     private CustomerService customerService;

     @Autowired
     public ProfileController(CustomerService customerService) {
          this.customerService = customerService;
     }

     @PostMapping(value = "/profile")
     public Customer save(@RequestBody Customer customer) {
          return customerService.save(customer);
     }

     @GetMapping(value = "/profile/{id}")
     public Customer getCustomer(@PathVariable int id) {
          return customerService.getCustomerById(id);
     }

     @GetMapping(value = "/profiles")
     public List<Customer>  getCustomers() {
          return customerService.getCustomers();
     }

     @GetMapping(value = "/profile/name")
     public ResponseEntity<List<Customer>> getCustomerByName(@RequestParam String name) {

          List<Customer> customer = customerService.getCustomerByName(name);

          if (customer == null) {
               return ResponseEntity.notFound().build();
          } else {
               return ResponseEntity.ok().body(customer);
          }

     }

}
