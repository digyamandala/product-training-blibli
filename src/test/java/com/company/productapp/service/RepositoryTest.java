package com.company.productapp.service;


import com.company.productapp.entity.Product;
import com.company.productapp.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testRepository(){
        //Insert Test
        Product product = new Product("1", "5", "Macbook");
        productRepository.save(product);

        product = new Product("3", "1", "Piano");
        productRepository.save(product);

        Optional<Product> optional = productRepository.findById("1");
        Assert.assertTrue("Product should exists with id 1", optional.get().getId().equals("1"));



        //Update Test and findByName
        product = optional.get();
        product.setProductName("Samsung");
        productRepository.save(product);

        product = productRepository.findByProductName("Samsung");
        Assert.assertTrue("Samsung should be found", product.getProductName().equals("Samsung")
                && product != null);



        //Delete Test
        optional = productRepository.findById("3");
        if(optional.isPresent()){
            product = optional.get();
            productRepository.delete(product);

            optional = productRepository.findById("3");
            Assert.assertTrue("Should be null", !optional.isPresent());
        }

    }

}
