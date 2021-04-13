package com.farm.dao;

import com.farm.bean.Address;
import com.farm.bean.Product;
import com.farm.util.SqlUtil;

public class AddressDao {
    //查看某一用户地址总数，可限制用户地址保存个数
    public int count(int id){
        String sql = "select count(*) count from Address where userID=?";
        Address address = SqlUtil.query(Address.class, sql, id);
        return address.getCount();
    }
    //添加地址，用户和id一般是登录着的用户的id
    private boolean add(Integer userid, String addressinfo, String phone, String name, Integer judge){
        String sql = "insert into Address(userID,addressInfo,phone,name,judge) values(?,?,?,?,?)";
        return SqlUtil.updateall(sql,userid,addressinfo,phone,name,judge);
    }

    //修改某一用户的某一个地址
    private boolean update(Integer userid, String addressinfo, String phone, String name, Integer judge,int aid){
        String sql = "update Address set addressInfo=?,phone=?,name=?,judge=? where addressID=? and userID=?";
        return SqlUtil.updateall(sql,addressinfo,phone,name,judge,aid,userid);
    }
    //删除某一地址
    public boolean delete(int addressID){
        String sql = "delete from Address where addressID=?";
        return SqlUtil.updateall(sql,addressID);
    }
    //查看某一用户的全部地址信息
    public Address getOne(int addressID,Integer userid, String addressinfo, String phone, String name, Integer judge){
        String sql = "select addressID,userID,addressInfo,phone,name,judge from Address where userID=?";
        Address address = SqlUtil.query(Address.class, sql, addressID, userid, addressinfo, phone, name, judge);
        return address;
    }
}
