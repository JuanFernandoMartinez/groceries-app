package com.escomart.home.groceries_app.DTO;

import java.util.UUID;

public record ProductStockDTO(
    UUID id,
    ProductDTO product,
    int quantity,
    int minimumQuantity,
    int idealQuantity
) {
    
}
