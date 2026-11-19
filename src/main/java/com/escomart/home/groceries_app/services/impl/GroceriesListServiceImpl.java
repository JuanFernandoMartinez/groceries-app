package com.escomart.home.groceries_app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.escomart.home.groceries_app.entities.GroceriesList;
import com.escomart.home.groceries_app.entities.ProductListItem;
import com.escomart.home.groceries_app.entities.ProductStock;
import com.escomart.home.groceries_app.repositories.GroceriesListRepository;
import com.escomart.home.groceries_app.repositories.ProductListRepository;
import com.escomart.home.groceries_app.repositories.ProductStockRepository;
import com.escomart.home.groceries_app.services.GroceriesListService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GroceriesListServiceImpl implements GroceriesListService {

    private final GroceriesListRepository groceriesListRepository;
    private final ProductListRepository productListRepository;
    private final ProductStockRepository productStockRepository;

    @Override
    public GroceriesList createGroceriesList(List<ProductListItem> products, String title, String summary) {
        GroceriesList groceriesList = new GroceriesList();
        groceriesList.setActive(true);
        groceriesList.setPreviewBudget(products.stream().mapToDouble(product -> product.getProduct().getPrice()).sum());
        products = saveGroceriesListProductList(products);
        groceriesList.setProducts(products);
        groceriesList.setSummary(summary);
        groceriesList.setTitle(title);

        return groceriesListRepository.save(groceriesList);

    }

    private List<ProductListItem> saveGroceriesListProductList(List<ProductListItem> products) {
        return products.stream().map(product -> productListRepository.save(product)).toList();
    }

    @Override
    public GroceriesList getListById(UUID id) {
        return groceriesListRepository.findById(id).orElse(null);
    }

    @Override
    public List<GroceriesList> getAllLists() {
        return groceriesListRepository.findAll();
    }

    @Override
    public GroceriesList addProductToList(UUID id, ProductListItem productListItem) {

        Optional<GroceriesList> groceriesList = groceriesListRepository.findById(id);
        if (groceriesList.isPresent()){
            productListItem = productListRepository.save(productListItem);
            groceriesList.get().getProducts().add(productListItem);
            groceriesList.get().setPreviewBudget(groceriesList.get().getPreviewBudget()+productListItem.getProduct().getPrice());

            groceriesListRepository.save(groceriesList.get());
        }

        return  groceriesList.get();
    }

    @Override
    public ProductListItem buyProduct(UUID listId, UUID proUuid, int total, double realPrice) {
        ProductListItem productListItem = productListRepository.findById(proUuid).orElse(null);
        if (productListItem != null){
            productListItem.setRealPrice(realPrice);
            productListItem.setRealTotal(total);
            
            productListRepository.save(productListItem);
        }

        return productListItem;

        
    }

    @Override
    public GroceriesList completeList(UUID listId) {
        Optional<GroceriesList> groceriesList = groceriesListRepository.findById(listId);

        if (groceriesList.isPresent()){
            groceriesList.get().setActive(false);

            //update stock products
            groceriesList.get().getProducts().stream().forEach(x->{
                List<ProductStock> productStockList = productStockRepository.findByProduct_id(x.getProduct().getId());
                productStockList.forEach(y-> {
                    y.getProduct().setPrice(x.getRealPrice());
                    y.setQuantity(y.getQuantity()+x.getRealTotal());
                    
                    productStockRepository.save(y);
                });
            });
            
            groceriesList.get().setRealBudget(groceriesList.get().getProducts().stream().mapToDouble(x-> x.getRealPrice()).sum());
            
            groceriesListRepository.save(groceriesList.get());


        }

        return groceriesList.get();
    }

}
