package com.farm.bean;

public class Attribute {
    private Integer attributeID;

    private String attributeName;

    private Integer categoryID;

    private int count;

    public Attribute() {
    }

    public Attribute(Integer attributeID, String attributeName, Integer categoryID) {
        this.attributeID = attributeID;
        this.attributeName = attributeName;
        this.categoryID = categoryID;
    }

    public Integer getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(Integer attributeID) {
        this.attributeID = attributeID;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "attributeID=" + attributeID +
                ", attributeName='" + attributeName + '\'' +
                ", categoryID=" + categoryID +
                ", count=" + count +
                '}';
    }
}