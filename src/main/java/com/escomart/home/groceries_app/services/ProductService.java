package com.escomart.home.groceries_app.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.escomart.home.groceries_app.entities.Product;
import com.escomart.home.groceries_app.repositories.ProductRepository;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class ProductService {

    private final ProductRepository productRepository;


    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product getProductById(UUID productId){
        return productRepository.findById(productId).orElse(null);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

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
    

}
