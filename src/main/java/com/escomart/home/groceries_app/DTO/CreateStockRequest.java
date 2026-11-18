package com.escomart.home.groceries_app.DTO;

import java.util.List;

public record CreateStockRequest(
    String name,
    String summary,
    List<CreateStockProductRequest> products
) {
    
}
