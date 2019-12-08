package com.rajithk.rentcloud.profileservice.repository;

import com.rajithk.rentcloud.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM Customer WHERE firstName =  ?1", nativeQuery = true)
    List<Customer> getCustomerByName(String name);
}
