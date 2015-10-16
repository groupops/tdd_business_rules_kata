package com.epam.training;

public class Product {
    private ProductCategory category;
    private String name;

    public Product(ProductCategory category, String name) {
        this.category = category;
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
