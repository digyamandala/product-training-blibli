package com.company.productapp.controller;

import com.company.productapp.entity.Product;
import com.company.productapp.entity.ApiKey;
import com.company.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller CONSISTS OF REQUEST AND RESPONSE WHEN THE URL IS ACCESSED
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String hello(ApiKey apiKey) {
        return "hello";
    }
    @RequestMapping(
            value = "/products",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Product> findAll(ApiKey apiKey) {
        return productService.findAll();
    }

    @RequestMapping(
            value = "/products",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product create(@RequestBody Product p, ApiKey apiKey){

        return productService.create(p);
    }

    @RequestMapping(
            value = "/products/{idProducts}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product findById(@PathVariable("idProducts") String id, ApiKey apiKey){
        return productService.findById(id);
    }


    @RequestMapping(
            value = "/products/{idProducts}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product delete(@PathVariable("idProducts") String id, ApiKey apiKey){
        return productService.delete(id);
    }

    @RequestMapping(
            value = "/products/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product update(@RequestBody Product p, ApiKey apiKey){

        return productService.update(p);
    }

}

