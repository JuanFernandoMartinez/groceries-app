package com.escomart.home.groceries_app.DTO;

import java.util.UUID;

public record ProductDTO(
    UUID id,
    String name,
    String summary,
    double price,
    String measureUnit
) {}
