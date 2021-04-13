package com.farm.bean;

public class Genetration {
    private Users userID;           //用户id，注意类型
    private Order orderID;          //订单id，注意类型
    private String orderStatus;     //订单状态
    private String buyOrSale;       //买或卖

    @Override
    public String toString() {
        return "Genetration{" +
                "userID=" + userID +
                ", orderID=" + orderID +
                ", orderStatus='" + orderStatus + '\'' +
                ", buyOrSale='" + buyOrSale + '\'' +
                '}';
    }

    public Genetration(Users userID, Order orderID, String orderStatus, String buyOrSale) {
        this.userID = userID;
        this.orderID = orderID;
        this.orderStatus = orderStatus;
        this.buyOrSale = buyOrSale;
    }

    public Genetration() {
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getBuyOrSale() {
        return buyOrSale;
    }

    public void setBuyOrSale(String buyOrSale) {
        this.buyOrSale = buyOrSale;
    }
}
