package com.company.productapp.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    private EntityManagerFactory factory;

    @Test
    public void testInsertProduct(){
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
