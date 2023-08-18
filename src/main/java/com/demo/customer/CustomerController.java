package com.demo.customer;

import com.demo.customer.dto.CustomerCreationDTO;
import com.demo.customer.dto.CustomerResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;
import java.util.Set;
import java.util.HashSet;
import java.util.Optional;

@RestController
@RequestMapping("customers")
public class CustomerController {

    Set<CustomerResponseDTO> customers = new HashSet<>();

    @PostMapping
    ResponseEntity<Void> create(@RequestBody CustomerCreationDTO payload, UriComponentsBuilder ucb) {
        CustomerResponseDTO customer = new CustomerResponseDTO(UUID.randomUUID(), payload.name(), payload.document());
        customers.add(customer);
        URI uri = ucb.path("customers/{id}")
                .buildAndExpand(customer.id())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("{id}")
    ResponseEntity<CustomerResponseDTO> read(@PathVariable UUID id) {
        Optional<CustomerResponseDTO> customer = customers.stream()
                .filter(c -> c.id().equals(id))
                .findAny();

        return customer.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    ResponseEntity<Set<CustomerResponseDTO>> readAll() {
        return ResponseEntity.ok(customers);
    }

    @PutMapping("{id}")
    ResponseEntity<Void> update(@RequestBody CustomerCreationDTO payload, @PathVariable UUID id) {
        Optional<CustomerResponseDTO> optional = customers.stream()
                .filter(c -> c.id().equals(id))
                .findAny();

        if (optional.isEmpty()) return ResponseEntity.notFound().build();

        customers.remove(optional.get());
        customers.add(new CustomerResponseDTO(id, payload.name(), payload.document()));

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id) {
        customers.stream()
                .filter(c -> c.id().equals(id))
                .findAny()
                .ifPresent(c -> customers.remove(c));
    }
}
