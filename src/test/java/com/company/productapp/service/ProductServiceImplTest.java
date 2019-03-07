package com.company.productapp.service;

import com.company.productapp.entity.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductServiceImplTest {
    private ProductServiceImpl service;

    @Before
    public void setUp() throws Exception{
        service = new ProductServiceImpl();
    }

    @Test
    public void testCreate(){

        Product product = new Product("2", "1", "Samsung");
        service.create(product);

        product = new Product("1", "2", "Fashion");
        service.create(product);

        Assert.assertTrue("Data must be two", service.findAll().size() == 2);

        Product temp = service.findById("1");
        Assert.assertTrue("Id must be 1", temp == product);

    }

    @Test
    public void testFindById(){

        Product product = service.findById("popo");
        Assert.assertTrue("Data should be kosong", product == null);

        service.create(new Product("2", "3", "Movies"));

        product = service.findById("2");
        Assert.assertTrue("Data should be found", product != null);
    }

    @Test
    public void testUpdate() {
        Product p = new Product("3", "4", "Laptop");
        service.create(p);

        Product up = new Product("3", "4", "Electronic");
        p = service.update(up);

        Assert.assertTrue("Name must be Hape", p.getProductName().equals("Electronic"));

        p = service.update(new Product("23", "100", "ppopopo"));
        Assert.assertTrue("Should be none", p == null);
    }

    @Test
    public void testDelete(){

        service.create(new Product("1","3", "Fashion"));
        service.create(new Product("2","4", "Music"));
        service.create(new Product("3","5", "Game"));
        service.create(new Product("4","6", "Payment"));

        Product del = service.delete("4");
        Assert.assertTrue("len shoudl be three", service.findAll().size() == 3);

        Product delnul = service.delete("10");
        Assert.assertTrue("should be not found", delnul == null);

    }
}
