package com.farm.bean;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Product {
        private String productName;//产品名字
        private String title;           //标题
        private BigDecimal unitPrice; //价格
        private int stock;              //库存
        private Date updateDate;       //更新日期
        private Date launchDate;       //初始日期
        private int categoryID;  //分类
        private String specification;//按什么买
        private int productID;     //产品id
        private int UserID; //用户店铺
        private int count;
        private int allCount;
        private Picture firstProductImage;  //页面展示图片
        private List<Picture> productImages;//该产品全部图片，总集合
        /*private List<Picture> productSingleImages;//单个略缩图
        private List<Picture> productDetailImages;//详细图*/
        private List<Evaluation> evaluations;//评论


    public Product(String productName, String title, BigDecimal unitPrice, int stock, Date updateDate,
                   Date launchDate, int categoryID, String specification, int productID, Picture firstProductImage,
                   List<Picture> productImages,/* List<Picture> productSingleImages, List<Picture> productDetailImages,*/
                   List<Evaluation> evaluations, int userID) {
        this.productName = productName;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.updateDate = updateDate;
        this.launchDate = launchDate;
        this.categoryID = categoryID;
        this.specification = specification;
        this.productID = productID;
        this.firstProductImage = firstProductImage;
        this.productImages = productImages;
      /*  this.productSingleImages = productSingleImages;
        this.productDetailImages = productDetailImages;*/
        this.evaluations = evaluations;
        this.UserID = userID;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Product() {
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getCount() {
        return count;
    }

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Picture getFirstProductImage() {
        return firstProductImage;
    }

    public void setFirstProductImage(Picture firstProductImage) {
        this.firstProductImage = firstProductImage;
    }

    public List<Picture> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<Picture> productImages) {
        this.productImages = productImages;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", title='" + title + '\'' +
                ", unitPrice=" + unitPrice +
                ", stock=" + stock +
                ", updateDate=" + updateDate +
                ", launchDate=" + launchDate +
                ", categoryID=" + categoryID +
                ", specification='" + specification + '\'' +
                ", productID=" + productID +
                ", firstProductImage=" + firstProductImage +
                ", productImages=" + productImages +
                ", evaluations=" + evaluations +
                ", UserID=" + UserID +
                '}';
    }
}
