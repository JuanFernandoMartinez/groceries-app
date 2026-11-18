package com.escomart.home.groceries_app.DTO;

import java.util.List;
import java.util.UUID;

public record StockDTO(
    UUID id,
    String name,
    String summary,
    List<ProductStockDTO> products
) {
} 
