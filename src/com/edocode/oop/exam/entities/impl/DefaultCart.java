package com.edocode.oop.exam.entities.impl;

import com.edocode.oop.exam.entities.Cart;
import com.edocode.oop.exam.entities.Product;

import java.util.Arrays;

public class DefaultCart implements Cart {

    private static final int DEFAULT_PRODUCT_CAPACITY = 10;
    private Product[] products;
    private int lastIndex;

    {
        products = new Product[DEFAULT_PRODUCT_CAPACITY];
        lastIndex = 0;
    }

    @Override
    public boolean isEmpty() {
        return (products == null) || (products.length == 0) || products[0] == null;
    }

    @Override
    public void addProduct(Product productById) {
        if (productById == null) {
            return;
        }
        if (products.length <= lastIndex) {
            products = Arrays.copyOf(products, products.length << 1);
        }
        products[lastIndex++] = productById;
    }

    @Override
    public Product[] getProducts() {
        return Arrays.copyOf(products, lastIndex);
    }

    @Override
    public void clear() {
        products = new Product[DEFAULT_PRODUCT_CAPACITY];
    }
}
