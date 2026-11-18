package com.escomart.home.groceries_app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escomart.home.groceries_app.entities.ProductStock;

public interface ProductStockRepository extends JpaRepository<ProductStock, UUID> {
    
}
