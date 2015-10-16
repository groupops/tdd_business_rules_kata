package com.epam.training;

import java.util.*;

public final class Order {
    private Map<ProductCategory, List<Product>> products;

    public void add(Product product) {
        checkIfProductNotNull(product);
        initOrderIfNecessary();
        placeProductInOrder(product);
    }

    private void checkIfProductNotNull(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product is null");
        }
    }

    private void initOrderIfNecessary() {
        if (products == null) {
            products = new HashMap<>();
        }
    }

    private void placeProductInOrder(Product product) {
        ProductCategory category = product.getCategory();
        if (products.containsKey(category)) {
            products.get(category).add(product);
        } else {
            List<Product> currentProducts = new ArrayList<>();
            currentProducts.add(product);
            products.put(category, currentProducts);
        }
    }

    public Map<ProductCategory, List<Product>> getAll() {
        return products;
    }
}
