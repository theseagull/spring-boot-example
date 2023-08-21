package com.its.buma.springbootexample.customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
) {
}