package com.epam.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DefaultOrderService implements OrderService {
    private final Order order = new Order();

    public void addProduct(Product product) {
        order.add(product);
    }

    public List<Product> getAll() {
        Map<ProductCategory, List<Product>> products = order.getAll();
        List<Product> allProducts = new ArrayList<>();
        products.values().forEach(allProducts::addAll);
        return allProducts;
    }

    public Set<ProductCategory> getCategories() {
        return order.getAll().keySet();
    }

    public List<Product> getProductsFromCategory(ProductCategory category) {
        return order.getAll().get(category);
    }
}
