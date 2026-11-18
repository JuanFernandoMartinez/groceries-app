package com.escomart.home.groceries_app.mapper;

import com.escomart.home.groceries_app.DTO.StockDTO;
import com.escomart.home.groceries_app.entities.Stock;

public class StockMapper {
    
    private StockMapper(){}

    public static Stock fromDTO(StockDTO stockDTO){
        Stock stock = new Stock();
        stock.setId(stockDTO.id());
        stock.setName(stockDTO.name());
        stock.setSummary(stockDTO.summary());
        stock.setProducts(stockDTO.products().stream().map(ProductStockMapper::fromDTO).toList());

        return stock;
    }

    public static StockDTO fromEntity(Stock stock){
        StockDTO stockDTO = new StockDTO(
            stock.getId(),
            stock.getName(),
            stock.getSummary(),
            stock.getProducts().stream().map(ProductStockMapper::fromEntity).toList()
        );

        return stockDTO;
    }
}
