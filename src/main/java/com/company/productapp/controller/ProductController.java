package com.company.productapp.controller;

import com.company.productapp.Product;
import com.company.productapp.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(
            value = "/products",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product create(@RequestBody Product p){

        return productService.create(p);
    }

    @RequestMapping(
            value = "/products/{idProducts}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product findById(@PathVariable("idProducts") String id){

        return productService.findById(id);
    }


    @RequestMapping(
            value = "/products",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Product> findAll() {
        return productService.findAll();
    }

    @RequestMapping(
            value = "/products/{idProducts}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product delete(@PathVariable("idProducts") String id){
        return productService.delete(id);
    }

    @RequestMapping(
            value = "/products/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product update(@RequestBody Product p){
        return productService.update(p);
    }
}
