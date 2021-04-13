package com.farm.bean;

import java.util.List;

public class Users {
    private String userName;         //账号
    private String password;        //密码
    private int businessType;  //类型，即分类的id^
    private String email;           //邮箱
    private String userPhone;       //电话
    private int userID;             //id
    private String ownerName;       //真是姓名
    private String businessName;    //店铺名
    private String businessAddress; //店铺地址
    private String businessphone;       //电话
    private String userphoto;  //头像图片^
    private List<Address> addresses;//存放该用户的地址，个人中心用
    private int count;

    public Users() {
    }

    public Users(String userName, String password, int businessType, String email, String userPhone, int userID, String ownerName, String businessName, String businessAddress, String businessphone, String userphoto, List<Address> addresses) {
        this.userName = userName;
        this.password = password;
        this.businessType = businessType;
        this.email = email;
        this.userPhone = userPhone;
        this.userID = userID;
        this.ownerName = ownerName;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessphone = businessphone;
        this.userphoto = userphoto;
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", businessType=" + businessType +
                ", email='" + email + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userID=" + userID +
                ", ownerName='" + ownerName + '\'' +
                ", businessName='" + businessName + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                ", businessPhone='" + businessphone + '\'' +
                ", userPhoto=" + userphoto +
                ", addresses=" + addresses +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getBusinessphone() {
        return businessphone;
    }

    public void setBusinessphone(String businessphone) {
        this.businessphone = businessphone;
    }


    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public int getBusinessType() {
        return businessType;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }
}
