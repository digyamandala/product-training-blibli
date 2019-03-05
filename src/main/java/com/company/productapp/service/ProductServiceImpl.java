package com.company.productapp.service;

import com.company.productapp.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

        private ArrayList<Product> products = new ArrayList<>();
        @Override
        public Product create(Product product) {
            products.add(product);
            return product;
        }

        @Override
        public Product update(Product product) {
            Product curr;
            for(int i = 0 ; i < products.size() ; i++){
                curr = products.get(i);
                if(product.getProductid().equals(curr.getProductid())){
                    products.set(i, product);
                    return products.get(i);
                }
            }
            return null;
        }

        @Override
        public Product delete(String id) {
            Product curr;
            for(int i = 0 ; i < products.size() ; i++){
                curr = products.get(i);

                if(id.equals(curr.getProductid())){
                    products.remove(curr);
                    return curr;
                }
            }
            return null;
        }

        @Override
        public Product findById(String id) {

            for(int i = 0 ; i < products.size() ; i++){
                if(id.equals(products.get(i).getProductid())){
                    return products.get(i);
                }
            }
            return null;
        }

        @Override
        public List<Product> findAll() {
            return products;
        }


}
