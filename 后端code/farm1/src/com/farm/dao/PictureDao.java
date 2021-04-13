package com.farm.dao;

import com.farm.bean.Attribute;
import com.farm.bean.Picture;
import com.farm.util.SqlUtil;

import java.util.List;

//@@
public class PictureDao {
    //查个数
    public int count() {
        String sql = " select count(*) count from Picture";
        Picture picture = SqlUtil.query(Picture.class, sql);
        return picture.getCount();
    }
    //插入图片ProductID =?，Pictureaddress =?
    public boolean add(String Pictureaddress){
        Picture picture = new Picture();
        int productID = picture.getProductID();
        String sql = "insert into Picture(ProductID,Pictureaddress) values(?,?)";
        return SqlUtil.updateall(sql,productID,Pictureaddress);
    }
    //删除图片
    public boolean delete(int PictureID){
        String sql = "delete from Picture where PictureID = ?";
        return SqlUtil.updateall(sql,PictureID);
    }
    //查找产品图片 urladdress
    public List<Picture> get(int ProductID){
        String sql = "select Pictureaddress from Picture where ProductID=?";
        List<Picture> pictures = SqlUtil.queryList(Picture.class, sql, ProductID);
        return pictures;
    }
    /**
     select * from Picture where PictureID = ?
     //PictureID,ProductID,Pictureaddress


     select * from Picture where ProductID =? and Pictureaddress =?
     //PictureID,ProductID,Pictureaddress
     //Pictureaddress更新为类型了，查找某一产品下的图片类型
     */
}
