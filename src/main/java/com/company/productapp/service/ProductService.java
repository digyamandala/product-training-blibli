package com.company.productapp.service;

import com.company.productapp.entity.Product;

import java.util.List;

//ProductService CONSISTS OF BLUEPRINT OF THE LOGIC

public interface ProductService {
    Product create(Product product);
    Product update(Product product);
    Product delete(String id);
    Product findById(String id);
    List<Product> findAll();
}
