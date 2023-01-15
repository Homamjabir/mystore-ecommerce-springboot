package com.mystore.ecommerce.controller;

import com.mystore.ecommerce.model.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/")
    public String getWeatherByCity() {
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}