package com.its.buma.springbootexample.customer;

public record CustomerRegistrationRequest(
        String name,
        String email,
        Integer age
) {
}
