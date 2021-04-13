package com.farm.bean;

import java.util.List;

public class Category {

    private String CategoryName;
    private int CategoryID;
    List<Product> products;
    List<List<Product>> productsByRow;



    public Category() {
    }

    public Category(String categoryName, int categoryID, List<Product> products, List<List<Product>> productsByRow) {
        CategoryName = categoryName;
        CategoryID = categoryID;
        this.products = products;
        this.productsByRow = productsByRow;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductsByRow() {
        return productsByRow;
    }

    public void setProductsByRow(List<List<Product>> productsByRow) {
        this.productsByRow = productsByRow;
    }

}