package com.mystore.ecommerce.service;

import com.mystore.ecommerce.model.Customer;
import com.mystore.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomer(String customerId) {
        return customerRepository.findAll().iterator().next();
    }


}
