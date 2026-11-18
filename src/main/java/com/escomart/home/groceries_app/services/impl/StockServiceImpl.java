package com.escomart.home.groceries_app.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.escomart.home.groceries_app.DTO.CreateStockProductRequest;
import com.escomart.home.groceries_app.DTO.CreateStockRequest;
import com.escomart.home.groceries_app.entities.Product;
import com.escomart.home.groceries_app.entities.ProductStock;
import com.escomart.home.groceries_app.entities.Stock;
import com.escomart.home.groceries_app.repositories.ProductStockRepository;
import com.escomart.home.groceries_app.repositories.StockRepository;
import com.escomart.home.groceries_app.services.ProductService;
import com.escomart.home.groceries_app.services.StockService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final ProductService productService;
    private final ProductStockRepository productStockRepository;

    @Override
    public Stock createStock(CreateStockRequest stock) {
        List<ProductStock> products = stock.products().stream()
                .map(x -> {
                    Product product = productService.getProductById(x.produuctId());
                    log.info("Product: {}", product);
                    if (product != null) {
                        ProductStock productStock = new ProductStock();
                        productStock.setIdealQuantity(x.idealQuantity());
                        productStock.setMinimumQuantity(x.minimumQuantity());
                        productStock.setProduct(product);
                        productStock.setQuantity(x.quantity());
                        productStock = productStockRepository.save(productStock);
                        log.info("productStock: {}", productStock);
                        return productStock;
                    } else {
                        log.error("Unable to create Product stock");
                        return null;
                    }
                }).toList();

        Stock newStock = new Stock();
        newStock.setName(stock.name());
        newStock.setSummary(stock.summary());
        newStock.setProducts(products);

        return stockRepository.save(newStock);
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
        if (oldStock != null) {
            oldStock.setId(stock.getId());
            oldStock.setName(stock.getName());
            oldStock.setProducts(stock.getProducts());
            oldStock.setSummary(stock.getSummary());

            stockRepository.save(oldStock);
        }

        return oldStock;
    }

    @Override
    public void deleteStock(UUID id) {
        stockRepository.deleteById(id);
    }

    @Override
    public Stock addProductToStock(UUID stockId, CreateStockProductRequest productStockRequest) {
        Stock stock = stockRepository.findById(stockId).orElse(null);

        Product product = productService.getProductById(productStockRequest.produuctId());

        log.info("Stock: {} product: {}", stock, product);
        if (product != null && stock != null) {
            ProductStock productStock = new ProductStock();
            productStock.setProduct(product);
            productStock.setIdealQuantity(productStockRequest.idealQuantity());
            productStock.setMinimumQuantity(productStockRequest.minimumQuantity());
            productStock.setQuantity(productStockRequest.quantity());

            productStock = productStockRepository.save(productStock);

            stock.getProducts().add(productStock);
            stockRepository.save(stock);
        }

        return stock;

    }

}
