package com.mystore.ecommerce.model;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String customerId;

    @Column(nullable = false)
    private String password;

    public Customer() {}


    public static class Builder {
        private String customerId;
        private String username;
        private String email;
        private String password;

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }



}