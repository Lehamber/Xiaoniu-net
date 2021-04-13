package com.farm.dao;

import com.farm.bean.Address;
import com.farm.bean.Attribute;
import com.farm.bean.Product;
import com.farm.util.SqlUtil;

import java.util.List;

public class AttributeDao {

    //查找某一分类的属性个数
    public int count(int categoryID) {
        String sql = "select count(*) from Attribute where categoryID =?";
        Attribute query = SqlUtil.query(Attribute.class, sql, categoryID);
        return query.getCount();
    }

    //插入属性，第一个？属性名称，第二个分类id
    public boolean add(String attributeName, Integer categoryID) {
        String sql = "insert into Attribute(attributeName,categoryID) values(?,?)";
        return SqlUtil.updateall(sql, attributeName, categoryID);
    }

    //更新属性
    public boolean update(Integer attributeid, String attributeName, Integer categoryID) {
        String sql = "update Attribute set categoryID= ?, attributeName=? where attributeID = ?";
        return SqlUtil.updateall(sql, categoryID, attributeName, attributeid);
    }

    // //删除属性
    public boolean delete(int categoryID) {
        String sql = "delete from Attribute where attributeID = ?";
        return SqlUtil.updateall(sql, categoryID);
    }

    //查找分类下的某一个属性
    public Attribute get(String attributeName, Integer categoryID) {
        String sql = "select attributeID,attributeName,categoryID from Attribute where attributeName = ? and categoryID = ?";
        Attribute attribute = SqlUtil.query(Attribute.class, sql, attributeName, categoryID);
        return attribute;
    }

    //查找分类下的全部属性
    public List<Attribute> getSome(Integer categoryID) {
        String sql = "select attributeID,attributeName,categoryID from Attribute where categoryID= ?";
        List<Attribute> list = SqlUtil.queryList(Attribute.class, sql, categoryID);
        return list;
    }

}
