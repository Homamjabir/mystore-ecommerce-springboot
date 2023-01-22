package com.mystore.ecommerce.mapper;

import com.mystore.ecommerce.model.Customer;
import com.mystore.ecommerce.api.register.RegisterCustomerRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityMapper {

    public Customer mapCustomerEntity(RegisterCustomerRequest registerCustomerRequest) {
        return new Customer.Builder()
                .customerId(registerCustomerRequest.getCustomerId())
                .email(registerCustomerRequest.getEmail())
                .password(registerCustomerRequest.getPassword())
                .username(registerCustomerRequest.getUsername())
                .build();
    }
}
