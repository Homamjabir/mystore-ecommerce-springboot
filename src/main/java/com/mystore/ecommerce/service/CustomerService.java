package com.mystore.ecommerce.service;

import com.mystore.ecommerce.api.login.LoginCustomerRequest;
import com.mystore.ecommerce.api.register.RegisterCustomerRequest;
import com.mystore.ecommerce.mapper.CustomerEntityMapper;
import com.mystore.ecommerce.model.Customer;
import com.mystore.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    public void createCustomer(RegisterCustomerRequest registerCustomerRequest) {
        customerRepository.save(customerEntityMapper.mapCustomerEntity(registerCustomerRequest));
    }

    public boolean getCustomer(LoginCustomerRequest loginCustomerRequest) {
        Customer customer = customerRepository.findByEmail(loginCustomerRequest.getEmail());
        return customer.getPassword().equals(loginCustomerRequest.getPassword());
    }


}
