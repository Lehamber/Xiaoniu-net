package com.farm.bean;

public class Address {
    private Integer addressID;

    private Integer userid;

    private String addressinfo;

    private String phone;

    private String name;

    private Integer judge;

    private int count;//用户保存地址总数

    @Override
    public String toString() {
        return "Address{" +
                "addressID=" + addressID +
                ", userid=" + userid +
                ", addressinfo='" + addressinfo + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", judge=" + judge +
                '}';
    }

    public Address(Integer addressID, Integer userid, String addressinfo, String phone, String name, Integer judge) {
        this.addressID = addressID;
        this.userid = userid;
        this.addressinfo = addressinfo;
        this.phone = phone;
        this.name = name;
        this.judge = judge;
    }

    public Address() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAddressinfo() {
        return addressinfo;
    }

    public void setAddressinfo(String addressinfo) {
        this.addressinfo = addressinfo == null ? null : addressinfo.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getJudge() {
        return judge;
    }

    public void setJudge(Integer judge) {
        this.judge = judge;
    }
}