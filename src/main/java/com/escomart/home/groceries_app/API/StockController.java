package com.escomart.home.groceries_app.API;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escomart.home.groceries_app.DTO.CreateStockProductRequest;
import com.escomart.home.groceries_app.DTO.CreateStockRequest;
import com.escomart.home.groceries_app.DTO.StockDTO;
import com.escomart.home.groceries_app.mapper.StockMapper;
import com.escomart.home.groceries_app.services.StockService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/stock")
@AllArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping
    public StockDTO creaetStock(@RequestBody CreateStockRequest createStockRequest) {
        return StockMapper.fromEntity(stockService.createStock(createStockRequest));
    }

    @GetMapping("/{id}")
    public StockDTO getStockById(@PathVariable UUID id) {
        return StockMapper.fromEntity(stockService.getStockById(id));
    }

    @GetMapping
    public List<StockDTO> getAllStocks() {
        return stockService.getAllStocks().stream().map(StockMapper::fromEntity).toList();
    }

    @PostMapping("/{id}/add-product")
    public StockDTO addProductToStock(@PathVariable UUID id, @RequestBody CreateStockProductRequest productRequest) {
        return StockMapper.fromEntity(stockService.addProductToStock(id, productRequest));
    }

}
