package com.escomart.home.groceries_app.mapper;

import com.escomart.home.groceries_app.DTO.ProductDTO;
import com.escomart.home.groceries_app.entities.Product;

public class ProductMapper {
    
    private ProductMapper(){

    }

    public static final Product fromDTO(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.id());
        product.setName(productDTO.name());
        product.setSummary(productDTO.summary());
        product.setPrice(productDTO.price());
        product.setMeasureUnit(productDTO.measureUnit());

        return product;
    }

    public static final ProductDTO fromEntity(Product product){
        ProductDTO productDTO = new ProductDTO(
            product.getId(),
            product.getName(),
            product.getSummary(),
            product.getPrice(),
            product.getMeasureUnit()
        );

        return productDTO;
    }
}
