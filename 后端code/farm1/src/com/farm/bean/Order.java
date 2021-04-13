package com.farm.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private int orderID;        //订单号
    private Date geneTime;      //订单时间
    private Users userID;       //用户号，注意类型
    private Address addressID;  //地址号，注意类型
    private BigDecimal orderMoney;          //价格
    private int quantity;              //数量
    private int count;//订单总个数
    private int productCount; //某产品的数量

    public Order(int orderID, Date geneTime, Users userID, Address addressID, BigDecimal orderMoney, int quantity) {
        this.orderID = orderID;
        this.geneTime = geneTime;
        this.userID = userID;
        this.addressID = addressID;
        this.orderMoney = orderMoney;
        this.quantity = quantity;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", geneTime=" + geneTime +
                ", userID=" + userID +
                ", addressID=" + addressID +
                ", orderMoney=" + orderMoney +
                ", quantity=" + quantity +
                '}';
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Address getAddressID() {
        return addressID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setAddressID(Address addressID) {
        this.addressID = addressID;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getGeneTime() {
        return geneTime;
    }

    public void setGeneTime(Date geneTime) {
        this.geneTime = geneTime;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

}
