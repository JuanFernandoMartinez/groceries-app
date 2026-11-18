package com.escomart.home.groceries_app.DTO;

import java.util.UUID;

public record CreateStockProductRequest(
    UUID produuctId,
    int quantity,
    int minimumQuantity,
    int idealQuantity
) {
    
}
