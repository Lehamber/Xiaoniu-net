package com.farm.dao;

import com.farm.bean.Category;
import com.farm.bean.Product;
import com.farm.util.SqlUtil;

import java.util.List;
//ok
public class CategoryDao {
    //根据id查信息
    public Category getOne(int CategoryID){
        String sql ="select CategoryID,CategoryName from Category where CategoryID = ?";
        Category category = SqlUtil.query(Category.class, sql, CategoryID);
        return category;
    }
    //根据名字查id
    public int getId(String name){
        String sql ="select CategoryID from Category where CategoryName = ?";
        Category category = SqlUtil.query(Category.class, sql, name);
        if (category != null) {
            return category.getCategoryID();
        }else {
            return 0;
        }
    }

    //模糊查名字
    public List<Category> getLikeName(String name){
        String sql ="select CategoryID,CategoryName from Category where CategoryName = '%'+?+'%'";
        List<Category> list = SqlUtil.queryList(Category.class, sql, name);
        return list;
    }

}
