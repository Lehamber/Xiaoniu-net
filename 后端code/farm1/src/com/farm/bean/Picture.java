package com.farm.bean;

public class Picture {
    private String Pictureaddress;//图片类型，即图片用在介绍还是用在详情
    //private Product product;//产品
    private int ProductID;
    private int PictureID;//图片id，即图片,url
    private int count;

    public Picture(String pictureaddress, int productID, int pictureID, int count) {
        Pictureaddress = pictureaddress;
        this.ProductID = productID;
        PictureID = pictureID;
        this.count = count;
    }

    public Picture() {
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        this.ProductID = productID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public String getPictureaddress() {
        return Pictureaddress;
    }

    public void setPictureaddress(String pictureaddress) {
        Pictureaddress = pictureaddress;
    }

    public int getPictureID() {
        return PictureID;
    }

    public void setPictureID(int pictureID) {
        PictureID = pictureID;
    }
}
