package com.demo.customer;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.Set;
import java.util.HashSet;

@Service
public class CustomerService {

    final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    Customer create(String name, String document) {
        return repository.save(new Customer(UUID.randomUUID().toString(), name, document));
    }

    Optional<Customer> read(UUID id) {
        return repository.findById(id.toString());
    }

    Set<Customer> readAll() {
        return new HashSet<>(repository.findAll());
    }

    void update(UUID id, String name, String document) {
        repository.findById(id.toString())
                .ifPresent(customer -> {
                    customer.setName(name);
                    customer.setDocument(document);
                    repository.save(customer);
                });
    }

    void delete(UUID id) {
        repository.findById(id.toString())
                .ifPresent(repository::delete);
    }

}
