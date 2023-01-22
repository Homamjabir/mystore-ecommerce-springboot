package com.mystore.ecommerce.api.login;

import com.mystore.ecommerce.api.register.RegisterCustomerRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class LoginCustomerRequest {

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

    public LoginCustomerRequest() {}

    public class Builder {
        private String email;
        private String password;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public LoginCustomerRequest build() {
            return new LoginCustomerRequest(this);
        }
    }

    private LoginCustomerRequest(Builder builder) {
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
