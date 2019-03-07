package com.company.productapp.repository;

import com.company.productapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByProductName(String name);
}
