package com.escomart.home.groceries_app.mapper;

import com.escomart.home.groceries_app.DTO.ProductStockDTO;
import com.escomart.home.groceries_app.entities.ProductStock;

public class ProductStockMapper {
    
    private ProductStockMapper(){

    }

    public static ProductStock fromDTO(ProductStockDTO productStockDTO){
        ProductStock productStock =  new ProductStock();
        productStock.setId(productStockDTO.id());
        productStock.setIdealQuantity(productStockDTO.idealQuantity());
        productStock.setMinimumQuantity(productStockDTO.minimumQuantity());
        productStock.setProduct(ProductMapper.fromDTO(productStockDTO.product()));
        productStock.setQuantity(productStockDTO.quantity());

        return productStock;
    }

    public static ProductStockDTO fromEntity(ProductStock productStock){
        ProductStockDTO productStockDTO = new ProductStockDTO(
            productStock.getId(),
            ProductMapper.fromEntity(productStock.getProduct()),
            productStock.getQuantity(),
            productStock.getMinimumQuantity(),
            productStock.getIdealQuantity()
        );

        return productStockDTO;
    }
}
