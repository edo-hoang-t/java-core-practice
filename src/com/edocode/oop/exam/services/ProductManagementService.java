package com.edocode.oop.exam.services;

import com.edocode.oop.exam.entities.Product;

import java.util.List;

public interface ProductManagementService {

    List<Product> getProducts();

    Product getProductById(int productIdToAddToCart);
}
