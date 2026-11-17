package com.escomart.home.groceries_app.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.escomart.home.groceries_app.entities.Stock;
import com.escomart.home.groceries_app.repositories.StockRepository;
import com.escomart.home.groceries_app.services.StockService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock getStockById(UUID id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock updateStock(UUID id, Stock stock) {
        Stock oldStock = stockRepository.findById(id).orElse(null);
        if (oldStock != null){
            oldStock.setId(stock.getId());
            oldStock.setName(stock.getName());
            oldStock.setProducts(stock.getProducts());
            oldStock.setSummary(stock.getSummary());

            stockRepository.save(oldStock);
        }

        return  oldStock;
    }

    @Override
    public void deleteStock(UUID id) {
        stockRepository.deleteById(id);
    }

}
