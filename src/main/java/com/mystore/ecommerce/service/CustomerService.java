package com.mystore.ecommerce.service;

import com.mystore.ecommerce.api.login.LoginCustomerRequest;
import com.mystore.ecommerce.api.register.RegisterCustomerRequest;
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

    public void createCustomer(RegisterCustomerRequest registerCustomerRequest) {
        customerRepository.save(mapCustomerEntity(registerCustomerRequest));
    }

    public boolean getCustomer(LoginCustomerRequest loginCustomerRequest) {
        Customer customer = customerRepository.findByEmail(loginCustomerRequest.getEmail());
        return customer.getPassword().equals(loginCustomerRequest.getPassword());
    }

    private Customer mapCustomerEntity(RegisterCustomerRequest registerCustomerRequest) {
        return new Customer.Builder()
                .customerId(registerCustomerRequest.getCustomerId())
                .email(registerCustomerRequest.getEmail())
                .password(registerCustomerRequest.getPassword())
                .username(registerCustomerRequest.getUsername())
                .build();
    }
}
