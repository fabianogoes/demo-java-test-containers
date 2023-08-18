package com.demo.customer;

import java.util.UUID;

public record CustomerResponseDTO(UUID id, String name, String document) {
}
