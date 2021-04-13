package com.farm.dao;

import com.farm.bean.Category;
import com.farm.bean.Picture;
import com.farm.bean.Users;
import com.farm.util.SqlUtil;

import java.util.List;

public class UsersDao {
    //登录
    public Users get(String username,String password) {
        String sql = "select userID,userName,password from Users where userName = ? and password=?";
        return SqlUtil.query(Users.class,sql,username,password);
    }

    //@@注册,第一个占位符是用户名，第二个邮箱，第三个电话，第四个是密码，注册时使用
    public boolean add(String userName, String Email, String userPhone, String password) {
        String sql =" insert into Users(userName,email,userPhone,password,userphoto,businessType,ownerName,businessName," +
                "businessAddress,businessphone)values(?,?,?,?,null,null,null,null,null,null)";
        boolean b = SqlUtil.updateall(sql, userName, Email, userPhone, password);
        if (b){
            return true;
        }
        return false;
    }
    //注册店铺
    public boolean addDian(String userName, String Email, String userPhone, String password) {
        String sql =" insert into Users(userName,email,userPhone,password,userphoto,businessType,ownerName,businessName," +
                "businessAddress,businessphone)values(?,?,? ,?,null,null,null,null,null,null)";

        boolean b = SqlUtil.updateall(sql, userName, Email, userPhone, password);
        if (b){
            return true;
        }
        return false;
    }

    //@@获取全部
    public List<Users> getTotal() {

        return null;
    }
    //查询用户数量，一般情况下管理员界面看人数使用
    public int getCount(){
        String sql = "select count(*) count from Users";
        Users users = SqlUtil.query(Users.class, sql);
        return users.getCount();

    }
    //根据用户名进行填写店铺信息，四个分别是类型、店铺名、地址、电话，注册时注册店铺时使用
    public void update(String ownerName,String businessType,String businessName,String businessAddress, String telephone,String userName){
        String sql ="update Users set ownerName= ?,businessType= ? , businessName = ? ," +
                "businessAddress = ? ,telephone=? where userName = ?";
        SqlUtil.updateall(sql,ownerName,businessType, businessName, businessAddress,  telephone, userName);
    }
    //注销账户使用，用户名查
    public boolean delete(String name){
        String sql = "delete from Users where userName =? ";
        return SqlUtil.updateall(sql,name);
    }
    //显示该用户全部信息，信息页展示使用，用户登录页验证用户名存在也使用，注册成功后展示信息也可使用
    public Users get(String name){
        String sql="select userName,email,userPhone,password,userphoto,ownerName,businessName," +
                "businessAddress,businessphone from Users where userName = ?";
        Users query = SqlUtil.query(Users.class, sql, name);
        if (query !=null){
            return query;
        }
        return null;
    }
    public String getBusinessName(String name){
        String sql="select businessName from Users where userName = ?";
        Users query = SqlUtil.query(Users.class, sql, name);
        if (query !=null){
            return query.getBusinessName();
        }
        return null;
    }
    //用户名查询id和password ，登录
    public int getId(String name){
        String sql="select userID,password from Users where userName = ?";
        Users users = SqlUtil.query(Users.class, sql, name);
        if(users != null){
            return users.getUserID();
        }
        return 0;
    }
    //用户名查询id和password ，登录
    public String getEmail (String Email ){
        String sql="select password from Users where Email = ?";
        Users users = SqlUtil.query(Users.class, sql, Email);
        if (users != null){
            return users.getPassword();
        }
        return null;
    }
    //用户名查询id和password ，登录
    public String getUserPhone (String userPhone ){
        String sql="select password from Users where userPhone = ?";
        Users users = SqlUtil.query(Users.class, sql, userPhone);
        if (users != null){
            return users.getPassword();
        }
        return null;
    }
    /**
     * 通过userID获取userName和userPhoto
     */
    public Users get(int userID){
        String sql="select userName,email,userPhone,password,userphoto,businessType,ownerName,businessName," +
                "businessAddress,businessphone from Users where userID = ?";
        return SqlUtil.query(Users.class,sql,userID);
    }

}
