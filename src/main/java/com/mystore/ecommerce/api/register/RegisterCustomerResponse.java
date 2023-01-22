package com.mystore.ecommerce.api.register;

public class RegisterCustomerResponse {
    private String response;

    public static class Builder {
        private String response;

        public Builder response(String response) {
            this.response = response;
            return this;
        }

        public RegisterCustomerResponse build() {
            return new RegisterCustomerResponse(this);
        }
    }

    private RegisterCustomerResponse(Builder builder) {
        this.response = builder.response;
    }

    public String getResponse() {
        return response;
    }


}
