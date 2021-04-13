package com.farm.util;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    //private static ResourceLoader resourceLoader = new DefaultResourceLoader();
    public static Connection getConnection() throws Exception {
        InputStream is =DBUtil.class.getClassLoader().getResourceAsStream("com/farm/jdbc.properties");
        /*Resource resource = resourceLoader.getResource("com/farm/jdbc.properties");
        InputStream is = resource.getInputStream();
        .getSystemResource("com/farm/jdbc.properties");*/
        Properties ps = new Properties();
        ps.load(is);

        String user=ps.getProperty("username");
        String password=ps.getProperty("password");
        String url=ps.getProperty("url");
        String driverClass=ps.getProperty("driverClassName");

        Class.forName(driverClass);


        Connection conn= DriverManager.getConnection(url,user,password);
        return conn;
    }

    public static void closeResource(Connection conn, Statement st){
        try {
            if(conn!=null){
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try {
            if(st!=null){
                st.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void closeResource(Connection conn, Statement st, ResultSet rs){
        try {
            if(conn!=null){
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try {
            if(st!=null){
                st.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try {
            if(rs!=null){
                rs.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
