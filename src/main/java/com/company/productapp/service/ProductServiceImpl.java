package com.company.productapp.service;

import com.company.productapp.entity.Product;
import com.company.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Product Service Implementation consists OF LOGIC.
//THAT CAME FROM THE BLUEPRINT

@Component
public class ProductServiceImpl implements ProductService {

//  private ArrayList<Product> products = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        productRepository.save(product);
//        products.add(product);
        return product;
    }

    @Override
    public Product update(Product product) {

        Optional<Product> optional = productRepository.findById(product.getId());
        if(optional.isPresent()){
            Product curr = optional.get();

            String newName = product.getProductName();
            String newCatId = product.getCategoryId();

            curr.setCategoryId(newCatId);
            curr.setProductName(newName);

            productRepository.save(curr);
            return curr;
        }
        return null;
    }

    @Override
    public Product delete(String id) {

        Optional<Product> optional = productRepository.findById(id);

        if(optional.isPresent()){
            Product temp = optional.get();
            productRepository.delete(temp);
        }

        return null;

    }

    @Override
    public Product findById(String id) {


        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent()){
            Product temp = optional.get();
            return temp;
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }


}
