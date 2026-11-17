package com.escomart.home.groceries_app.services;

import java.util.List;
import java.util.UUID;

import com.escomart.home.groceries_app.entities.Stock;

public interface StockService {
    Stock createStock(Stock stock);

    Stock getStockById(UUID id);

    List<Stock> getAllStocks();

    Stock updateStock(UUID id, Stock stock);

    void deleteStock(UUID id);
}
