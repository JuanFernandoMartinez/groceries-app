package com.escomart.home.groceries_app.services;

import java.util.List;
import java.util.UUID;

import com.escomart.home.groceries_app.entities.Product;

public interface ProductService {

    Product createProduct(Product product);

    Product getProductById(UUID id);

    List<Product> getProducts();

    Product updateProduct(UUID id, Product product);

    void  deleteProduct(UUID id);
} 
