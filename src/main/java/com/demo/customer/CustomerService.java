package com.demo.customer;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer create(String name, String document) {
        return repository.save(new Customer(UUID.randomUUID().toString(), name, document));
    }

}
