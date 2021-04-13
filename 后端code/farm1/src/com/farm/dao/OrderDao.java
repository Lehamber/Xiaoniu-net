package com.farm.dao;

import com.farm.bean.Address;
import com.farm.bean.Order;
import com.farm.bean.Users;
import com.farm.util.DateUtil;
import com.farm.util.SqlUtil;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class OrderDao {

    //订单总个数
    public int count(){
        String sql = "select count(*) count from [Order]";
        Order order = SqlUtil.query(Order.class, sql);
        return order.getCount();
    }
    //某一个产品的订单个数
    public int productcCount(int productID){
        String sql = "select count(*) productCount from [Order] where productID = ?";
        Order order = SqlUtil.query(Order.class, sql,productID);
        return order.getProductCount();
    }
    //插入orderMoney=?,geneTime=?,quantity=?,productID=?,addressID=?
    public Date add(int productID,Date geneTime, int addressID, BigDecimal orderMoney, int quantity){
        Timestamp s = DateUtil.u2s(geneTime);
        String sql = "insert into [Order](orderMoney,geneTime,quantity,productID,addressID) values(?,?,?,?,?)";
        if(SqlUtil.updateall(sql,orderMoney,s,quantity,productID,addressID))
            return geneTime;
        return null;
    }
    //更新信息
    public boolean update(int productID,Date geneTime, int addressID, BigDecimal orderMoney, int quantity,int orderID){
        Timestamp s = DateUtil.u2s(geneTime);
        String sql = "update [Order] set orderMoney=?,geneTime=?,quantity=?,productID=?,addressID=? where orderID=?";
        return SqlUtil.updateall(sql,orderMoney,s,quantity,productID,addressID,orderID);
    }
    //删除某一信息
    public boolean delete(int orderID){
        String sql = "delete from [Order] where orderID=?";
        return SqlUtil.updateall(sql,orderID);
    }
    //查找全部信息
    public Order get(int orderID){
        String sql = "select orderID,orderMoney,geneTime,quantity,productID,addressID from [Order] where orderID=?";
        Order order = SqlUtil.query(Order.class, sql, orderID);
        return order;
    }
    //查找订单Id
    public Order getOrderId(Date geneTime){
        Timestamp s = DateUtil.u2s(geneTime);
        String sql = "select orderID from [Order] where geneTime=?";
        Order order = SqlUtil.query(Order.class, sql, s);
        return order;
    }
}
