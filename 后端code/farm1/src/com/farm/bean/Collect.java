package com.farm.bean;

public class Collect {
    private Product productID;
    private Users userID;
    private int count;

    public Collect(Product productID, Users userID) {
        this.productID = productID;
        this.userID = userID;
    }

    public Collect() {
    }

    @Override
    public String toString() {
        return "Collect{" +
                "productID=" + productID +
                ", userID=" + userID +
                '}';
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
