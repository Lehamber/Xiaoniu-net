package com.farm.bean;

public class AttributeValue {
    private Integer attributeValueID;

    private String value;

    private Integer attributeID;

    private Integer productID;
    private int count;
    public AttributeValue() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public AttributeValue(Integer attributeValueID, String value, Integer attributeID, Integer productID) {
        this.attributeValueID = attributeValueID;
        this.value = value;
        this.attributeID = attributeID;
        this.productID = productID;
    }

    public Integer getAttributeValueID() {
        return attributeValueID;
    }

    public void setAttributeValueID(Integer attributeValueID) {
        this.attributeValueID = attributeValueID;
    }

    public Integer getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(Integer attributeID) {
        this.attributeID = attributeID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "AttributeValue{" +
                "attributeValueID=" + attributeValueID +
                ", value='" + value + '\'' +
                ", attributeID=" + attributeID +
                ", productID=" + productID +
                ", count=" + count +
                '}';
    }
}