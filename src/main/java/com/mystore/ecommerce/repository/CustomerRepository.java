package com.mystore.ecommerce.repository;

import com.mystore.ecommerce.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findByUsername(String username);
    Customer findByEmail(String email);
    Customer findByCustomerId(String customerId);
}

