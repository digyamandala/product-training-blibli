package com.company.productapp.service;

import com.company.productapp.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product update(Product product);
    Product delete(String id);
    Product findById(String id);
    List<Product> findAll();
}
