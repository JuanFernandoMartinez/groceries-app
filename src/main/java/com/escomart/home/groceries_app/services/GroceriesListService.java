package com.escomart.home.groceries_app.services;

import java.util.List;
import java.util.UUID;

import com.escomart.home.groceries_app.entities.GroceriesList;
import com.escomart.home.groceries_app.entities.ProductListItem;

public interface GroceriesListService {
    GroceriesList createGroceriesList(List<ProductListItem> products, String title, String summary );

    GroceriesList getListById(UUID id);

    List<GroceriesList> getAllLists();

    GroceriesList addProductToList(UUID id,ProductListItem productListItem);

    ProductListItem buyProduct(UUID listId, UUID proUuid, int total, double realPrice);

    GroceriesList completeList(UUID listId);

}
