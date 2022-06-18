package com.edocode.oop.exam.entities.impl;

import com.edocode.oop.exam.entities.Cart;
import com.edocode.oop.exam.entities.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultCart implements Cart {

    private static final int DEFAULT_PRODUCT_CAPACITY = 10;
    private List<Product> products;
    private int lastIndex;

    {
        products = new ArrayList<>();
        lastIndex = 0;
    }

    @Override
    public boolean isEmpty() {
        return (products == null) || (products.isEmpty()) || products.get(0) == null;
    }

    @Override
    public void addProduct(Product productById) {
        if (productById == null) {
            return;
        }
        products.add(productById);
    }

    @Override
    public List<Product> getProducts() {
        return this.products;
    }

    @Override
    public void clear() {
        products.clear();
    }
}
