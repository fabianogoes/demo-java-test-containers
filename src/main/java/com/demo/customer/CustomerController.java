package com.demo.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<Void> create(@RequestBody CustomerCreationDTO payload, UriComponentsBuilder ucb) {
        Customer customer = service.create(payload.name(), payload.document());
        URI uri = ucb.path("customers/{id}")
                .buildAndExpand(customer.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("{id}")
    ResponseEntity<CustomerResponseDTO> read(@PathVariable UUID id) {
        Customer customer = service.read(id);

        if (customer == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(CustomerConvert.toResponse(customer));
    }

    @GetMapping
    ResponseEntity<Set<CustomerResponseDTO>> readAll() {
        Set<CustomerResponseDTO> response = service.readAll().stream()
                .map(CustomerConvert::toResponse)
                .collect(Collectors.toSet());

        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    ResponseEntity<Void> update(@RequestBody CustomerCreationDTO payload, @PathVariable UUID id) {
        if (service.read(id) == null)
            return ResponseEntity.notFound().build();

        service.update(id, payload.name(), payload.document());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void>  delete(@PathVariable UUID id) {
        if (service.read(id) == null)
            return ResponseEntity.notFound().build();

        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

record CustomerCreationDTO(String name, String document) {
}
record CustomerResponseDTO(UUID id, String name, String document) {
}

class CustomerConvert {
    public static CustomerResponseDTO toResponse(Customer customer) {
        return new CustomerResponseDTO(UUID.fromString(customer.getId()), customer.getName(), customer.getDocument());
    }
}
