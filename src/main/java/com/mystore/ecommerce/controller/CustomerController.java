package com.mystore.ecommerce.controller;

import com.mystore.ecommerce.api.login.LoginCustomerRequest;
import com.mystore.ecommerce.api.login.LoginCustomerResponse;
import com.mystore.ecommerce.api.register.RegisterCustomerRequest;
import com.mystore.ecommerce.api.register.RegisterCustomerResponse;
import com.mystore.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/register")
    public RegisterCustomerResponse registerCustomer(@Valid @RequestBody RegisterCustomerRequest registerCustomerRequest) {
        try {
            customerService.createCustomer(registerCustomerRequest);
        } catch (Exception e) {
            return new RegisterCustomerResponse.Builder()
                    .response("Error")
                    .build();
        }
        return new RegisterCustomerResponse.Builder()
                .response("Created")
                .build();
    }

    @PostMapping ("/login")
    public String getCustomer(@Valid @RequestBody LoginCustomerRequest loginCustomerRequest) {
        try {
            if(customerService.getCustomer(loginCustomerRequest)) {
                return "Logged in";
            }
        } catch (Exception e) {
            return "Error";
        }
        return "Wrong email or password";

    }

}