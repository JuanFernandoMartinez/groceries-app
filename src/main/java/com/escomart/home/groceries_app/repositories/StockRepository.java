package com.escomart.home.groceries_app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escomart.home.groceries_app.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, UUID>{
    
}
