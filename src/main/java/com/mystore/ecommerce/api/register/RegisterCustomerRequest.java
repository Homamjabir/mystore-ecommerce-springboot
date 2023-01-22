package com.mystore.ecommerce.api.register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class RegisterCustomerRequest {

    @Pattern(regexp = "\\d{12}")
    @NotNull
    private String customerId;

    @NotNull
    private String username;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

    public RegisterCustomerRequest() {}

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

        public RegisterCustomerRequest build() {
            return new RegisterCustomerRequest(this);
        }
    }

    private RegisterCustomerRequest(Builder builder) {
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
