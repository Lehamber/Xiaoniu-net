package com.farm.servlet;


import com.farm.bean.Users;
import com.farm.readJson.UsersJson;
import com.farm.util.JsonUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersServlet extends BaseServlet{

    /**
     * 登录：http://172.32.100.201:8080/farm1/userServlet?method=login
     * http://172.32.100.201:8080/farm1/userServlet/login
     * @return
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("userID");
        String password = request.getParameter("password");
        System.out.println("account = " + account+", password = " + password);
        System.out.println("users = " + userDAO.get(account, password)+"\npass = " + userDAO.getEmail(account)+"\npass2 = " + userDAO.getUserPhone(account));

        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        Map<String, Object> map1 = JsonUtil.toSuccessMap();
        Map<String, Object> map = new HashMap<>();

        if((userDAO.get(account, password) != null) || (userDAO.getEmail(account)==password) || (userDAO.getUserPhone(account)==password)){
            map.put("confirm",1);
            map.put("userName",account);
            map1.put("data",map);
            String s = gson.toJson(map1);
            out.write(s);
        }else {
            map.put("confirm",0);
            map1.put("data",map);
            String s1 = gson.toJson(map1);
            out.write(s1);
        }
        out.flush();
        out.close();

    }

    /**
     * http://172.32.100.201:8080/farm1/userServlet/register
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userPhone = request.getParameter("userPhone");
        System.out.println("name = " + name+"email = " + email+"password = " + password+"userPhone = " + userPhone);

        int userflag=0, emailflag=0,phoneflag=0;
        boolean add=false;
        if(userDAO.get(name) == null){
            userflag=1;
        }
        if(userDAO.getEmail(email) == null){
            emailflag=1;
        }
        if(userDAO.getUserPhone(userPhone) == null){
            phoneflag=1;
        }
        if((userflag==1) && (emailflag==1) && (phoneflag==1)){
            add = userDAO.add(name, email, userPhone, password);
        }
        System.out.println("userflag = " + userflag+"emailflag = " + emailflag+"phoneflag = " + phoneflag);
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        Map<String, Object> map1 = JsonUtil.toSuccessMap();
        Map<String, Object> map = new HashMap<>();
        map.put("UserNameSta",userflag);
        map.put("emailSta",emailflag);
        map.put("userPhoneSta",phoneflag);
        map1.put("data",map);

        String s = gson.toJson(map1);
        out.write(s);
        out.flush();
        out.close();
    }
    /*public void register(HttpServletRequest request, HttpServletResponse response){
        String jsonData = JsonUtil.readJsonData(request);
        System.out.println("jsonData = " + jsonData);
        Gson gson = new Gson();
        UsersJson users = gson.fromJson(jsonData, UsersJson.class);
        System.out.println("fromjson>>>>users = " + users);
        String name = users.getUserName();
        String email = users.getEmail();
        String userPhone = users.getUserPhone();
        String password = users.getPassword();
        System.out.println("name = " + name+"email = " + email+"password = " + password+"userPhone = " + userPhone);

    }*/

    //2-首页验证
    public void verify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("userID");
        String password = request.getParameter("password");
        System.out.println("account = " + account+", password = " + password);
        System.out.println("users = " + userDAO.get(account, password)+"\npass = " + userDAO.getEmail(account)+"\npass2 = " + userDAO.getUserPhone(account));
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        Map<String, Object> map2 = JsonUtil.toFailMap();
        Map<String, Object> map = new HashMap<>();

        if((userDAO.get(account, password) != null) || (userDAO.getEmail(account)==password) || (userDAO.getUserPhone(account)==password)){
            map.put("confirm",1);
            if (userDAO.getBusinessName(account)!=null){
                map.put("haveBusiness",1);
            }else{
                map.put("haveBusiness",0);
            }
        }else{
            map.put("confirm",0);
            map.put("haveBusiness",0);
        }
        map2.put("data",map);
        String s1 = gson.toJson(map2);
        System.out.println("map2 = " + map2);
        out.write(s1);
        out.flush();
        out.close();
    }

    public boolean update(HttpServletRequest request, HttpServletResponse response){

        return false;
    }
    public boolean delete(HttpServletRequest request, HttpServletResponse response){

        return false;
    }

}
