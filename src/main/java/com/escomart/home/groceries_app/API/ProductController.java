package com.escomart.home.groceries_app.API;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escomart.home.groceries_app.DTO.ProductDTO;
import com.escomart.home.groceries_app.mapper.ProductMapper;
import com.escomart.home.groceries_app.services.ProductService;

import lombok.AllArgsConstructor;

@RestController 
@RequestMapping("/product")
@AllArgsConstructor 
public class ProductController {

    private final ProductService productService;
    
    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
        return ProductMapper.fromEntity(productService.createProduct(ProductMapper.fromDTO(productDTO)));
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable UUID id){
        return ProductMapper.fromEntity(productService.getProductById(id));
    }

    @GetMapping 
    public List<ProductDTO> getProducts(){
        return productService.getProducts().stream().map(product -> ProductMapper.fromEntity(product)).toList();
    }

    @PutMapping("/{id}") 
    public ProductDTO updateProduct(@PathVariable UUID id, @RequestBody ProductDTO productDTO){
        return ProductMapper.fromEntity(productService.updateProduct(id, ProductMapper.fromDTO(productDTO)));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id){
        productService.deleteProduct(id);
    }
}
