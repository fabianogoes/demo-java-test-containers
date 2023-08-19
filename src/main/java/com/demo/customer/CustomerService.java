package com.demo.customer;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    Customer create(String name, String document) {
        return repository.save(new Customer(UUID.randomUUID().toString(), name, document));
    }

    Customer read(UUID id) {
        Optional<Customer> optional = repository.findById(id.toString());
        return optional.orElse(null);

    }

    Set<Customer> readAll() {
        return new HashSet<>(repository.findAll());
    }

    void update(UUID id, String name, String document) {
        Optional<Customer> optional = repository.findById(id.toString());
        if (optional.isPresent()) {
            Customer up = optional.get();
            up.setName(name);
            up.setDocument(document);

            repository.save(up);
        }
    }

    void delete(UUID id) {
        Optional<Customer> optional = repository.findById(id.toString());
        if (optional.isPresent())
            repository.deleteById(id.toString());
    }

}
