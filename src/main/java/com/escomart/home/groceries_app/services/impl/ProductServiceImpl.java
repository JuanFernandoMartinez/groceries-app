package com.escomart.home.groceries_app.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.escomart.home.groceries_app.entities.Product;
import com.escomart.home.groceries_app.repositories.ProductRepository;
import com.escomart.home.groceries_app.services.ProductService;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override 
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    @Override 
    public Product getProductById(UUID productId){
        return productRepository.findById(productId).orElse(null);
    }

    @Override 
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    
    @Override 
    public Product updateProduct(UUID id, Product product){
        Product olProduct = productRepository.findById(id).orElse(null);

        if (olProduct != null){
            olProduct.setMeasureUnit(product.getMeasureUnit());
            olProduct.setName(product.getName());
            olProduct.setPrice(product.getPrice());
            olProduct.setSummary(product.getSummary());
            productRepository.save(olProduct);
        }

        return olProduct;
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
