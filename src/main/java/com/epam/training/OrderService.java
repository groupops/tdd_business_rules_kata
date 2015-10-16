package com.epam.training;

import java.util.List;
import java.util.Set;

/**
 * Created by Dmytro_Ulanovych on 10/16/2015.
 */
public interface OrderService {

    void addProduct(Product product);

    List<Product> getAll();

    Set<ProductCategory> getCategories();

    List<Product> getProductsFromCategory(ProductCategory category);

}
