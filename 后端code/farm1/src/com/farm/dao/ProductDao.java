package com.farm.dao;

import com.farm.bean.Picture;
import com.farm.bean.Product;
import com.farm.util.DateUtil;
import com.farm.util.SqlUtil;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * ok
 */
public class ProductDao {
    //名字查id
    public int getId(String name){
        String sql ="select productID from Product where productName = ?";
        Product product = SqlUtil.query(Product.class, sql, name);
        return product.getProductID();
    }
    public int allCount(){
        String sql = "select count(*) allCount from Product";
        Product product = SqlUtil.query(Product.class, sql);
        return product.getAllCount();
    }
    //查找某一分类的全部产品的个数
    public int count(int categoryID){
        String sql = "select count(*) count from Product where categoryID = ?";
        Product product = SqlUtil.query(Product.class, sql, categoryID);
        return product.getCount();
    }
    //插入产品productName= ?, title=?, unitPrice=?,stock=?,updateDate=?, launchDate = ?, categoryID=?,specification =?

    public boolean add(String productName, String title, float unitPrice, int stock, Date updateDate, Date launchDate,int categoryID,String specification){
        Timestamp timestamp = DateUtil.u2s(updateDate);
        Timestamp timestamp1 = DateUtil.u2s(launchDate);
        String sql = "insert into Product (productName,title,unitPrice,stock,updateDate,launchDate,categoryID,specification)values(?,?,?,?,?,?,?,?)";
        return SqlUtil.updateall(sql,productName,title,unitPrice,stock,timestamp,timestamp1,categoryID,specification);
    }
    //根据id更新产品信息
    public boolean update(String productName, String title, float unitPrice, int stock, Date updateDate, Date launchDate,String specification,int categoryID,int productID){
        String sql = "update Product set productName= ?, title=?, unitPrice=?,stock=?,updateDate=?, launchDate = ?, categoryID=?,specification =?where productID = ?";
        Timestamp timestamp = DateUtil.u2s(updateDate);
        Timestamp timestamp1 = DateUtil.u2s(launchDate);
        return SqlUtil.updateall(sql, productName, title, unitPrice, stock, timestamp, timestamp1, categoryID, specification, productID);
    }
    //根据id删除产品
    public boolean delete(int productID){
        String sql = "delete from Product where productID = ?";
        return SqlUtil.updateall(sql,productID);
    }
    //根据id查找
    public Product get(int productID){
        String sql = "select productID,productName, title, unitPrice,stock,updateDate, " +
                                "launchDate , categoryID,specification,UserID  from Product where productID = ?";
        Product product = SqlUtil.query(Product.class, sql, productID);
        if(product != null)
            return product;
        else
            return null;
    }
    //模糊查询
    public List<Product> getSome(String productName){
        String sql = "select productID,productName, title, unitPrice,stock,updateDate, " +
                "launchDate , categoryID,specification  from Product where productName like '%'+?+'%'";
        List<Product> list = SqlUtil.queryList(Product.class, sql, productName);
        System.out.println("getSome, list长度 = " + list.size());
        return list;
    }
    //商品首页展示
    public List<Product> getTen(int categoryID){
        String sql = "select productID,productName, title, unitPrice,stock, " +
                "specification  from Product where categoryID = ? ";
        List<Product> list = SqlUtil.queryList(Product.class, sql, categoryID);
        //System.out.println("list = " + list);
        return list;
    }

    //查询产品的类型id
    public int getCategoryID(String productName){
        String sql = "select categoryID from Product where productName = ? ";
        Product product = SqlUtil.query(Product.class, sql, productName);
        if(product != null)
            return product.getCategoryID();
        return 0;
    }

}
