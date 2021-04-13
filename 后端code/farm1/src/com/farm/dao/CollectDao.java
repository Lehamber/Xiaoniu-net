package com.farm.dao;

import com.farm.bean.Collect;
import com.farm.util.SqlUtil;

import java.util.List;

public class CollectDao {
    //查看用户收藏的产品个数
    public int count(int id){
        String sql = "select count(*) count from Collect where userID=?";
        Collect query = SqlUtil.query(Collect.class, sql, id);
        return query.getCount();
    }
    //添加收藏，用户和id一般是登录着的用户的id
    public boolean add(int productID,int userID){
        String sql = "insert into Collect(productID,userID) values(?,?)";
        return SqlUtil.updateall(sql,productID,userID);
    }
    //删除用户某一收藏
    public boolean delete(int productID,int userID){
        String sql = "delete from bean.Collect where productID=? and userID=?";
        return SqlUtil.updateall(sql,productID,userID);
    }
    //查看某一用户的全部地址信息
    public List<Collect> get(int userID){
        String sql = "  select productID,userID from Collect where userID=?";
        List<Collect> list = SqlUtil.queryList(Collect.class, sql, userID);
        return list;
    }

}
