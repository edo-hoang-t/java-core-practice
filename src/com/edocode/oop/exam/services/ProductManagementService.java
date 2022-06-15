package com.edocode.oop.exam.services;

import com.edocode.oop.exam.entities.Product;

public interface ProductManagementService {

    Product[] getProducts();

    Product getProductById(int productIdToAddToCart);
}
