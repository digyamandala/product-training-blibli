package com.company.productapp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//THIS IS THE MODEL, THAT CONSISTS OF ATTRIBUTES
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    private String id;
    private String categoryId;

    @Column(nullable = false)
    private String productName;


}
