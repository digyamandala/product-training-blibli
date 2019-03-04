package com.company.productapp;

public class Product {

    private int productid;
    private String productName;
    private String category;

    public Product(int productid, String productName, String category) {
        this.productid = productid;
        this.productName = productName;
        this.category = category;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
