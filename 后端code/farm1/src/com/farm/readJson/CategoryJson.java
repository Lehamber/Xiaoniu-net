package com.farm.readJson;

public class CategoryJson {
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryJson{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }
}
