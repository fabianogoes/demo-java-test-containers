package com.demo.customer.dto;

import java.util.UUID;

public record CustomerResponseDTO(UUID id, String name, String document) {
}
