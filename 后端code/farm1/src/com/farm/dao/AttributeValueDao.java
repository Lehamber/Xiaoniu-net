package com.farm.dao;

import com.farm.bean.AttributeValue;
import com.farm.util.SqlUtil;

public class AttributeValueDao {
    //属性详表
    public int count(){
        String sql ="select count(*) count from AttributeValue";
        AttributeValue query = SqlUtil.query(AttributeValue.class, sql);
        return query.getCount();
    }
    //插入value=?,attributeID=?,productID=?
    public boolean add(String value, Integer attributeid, Integer productid){
        String sql = "insert into AttributeValue(value,attributeID,productID) values(?,?,?)";
        return SqlUtil.updateall(sql,value,attributeid,productid);
    }
    //更新信息
    public boolean update(Integer attributevalueid, String value, Integer attributeid, Integer productid){
        String sql = "update AttributeValue set  value=? ,attributeID=?,productID=? where attributeValueID = ?";
        return SqlUtil.updateall(sql,value,attributeid,productid,attributevalueid);
    }
    //根据id删除
    public boolean delete(Integer attributevalueid){
        String sql = "delete from AttributeValue where attributeValueID = ?";
        return SqlUtil.updateall(sql,attributevalueid);
    }
    //根据id查找
    public AttributeValue get(Integer attributevalueid){
        String sql = "select attributeValueID,value,attributeID,productID from AttributeValue where attributeValueID =?";
        AttributeValue attributeValue = SqlUtil.query(AttributeValue.class, sql, attributevalueid);
        return attributeValue;
    }
    //查找产品的属性的属性详表
    public AttributeValue getDetail(Integer attributeid, Integer productid){
        String sql = "select attributeValueID,value,attributeID,productID from AttributeValue where attributeID = ? and productID = ?";
        AttributeValue attributeValue = SqlUtil.query(AttributeValue.class, sql, attributeid,productid)  ;
        return attributeValue;
    }
}