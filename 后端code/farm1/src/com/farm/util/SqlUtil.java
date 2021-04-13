package com.farm.util;
import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class SqlUtil {
    //查询
    public static <T> List<T> queryList(Class<T> clazz, String sql, Object ...args){
        //获取连接
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            //sql注入
            ps = conn.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            //执行查询获取结果集
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集的列数
            int columnCount = rsmd.getColumnCount();
            //创建集合对象
            ArrayList<T> list = new ArrayList<>();
            while (rs.next()){
                T t = clazz.newInstance();
                //处理结果集的每一列,给t对象指定属性赋值
                for (int i = 0; i <columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i+1);
                    //获取每个列的列名
                    String columnName = rsmd.getColumnLabel(i+1);
                    //获取列名后,反射类改变属性值
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                list.add(t);
            }
            return list;

        }catch  (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResource(conn,ps,rs);
        }
        return null;

    }
    //T是类的类型
    public static <T>T query(Class<T> clazz, String sql, Object ...args){
        //获取连接
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            //sql注入
            ps = conn.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            //执行查询获取结果集
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集的列数
            int columnCount = rsmd.getColumnCount();
            while (rs.next()){
                //调用默认构造方法，返回Class对象(对应的类型信息）的 一个实例，
                // 如果这里创建固定的对象的话，在运行时可能还会传进来不同的对象，这样就会导致编译时类型和运行时类型不同
                T t = clazz.newInstance();
                //处理结果集的每一列
                for (int i = 0; i <columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i+1);
                    //获取每个列的列名
                    String columnName = rsmd.getColumnLabel(i+1);
                    //获取列名后,反射类改变属性值
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                return t;
            }

        }catch  (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResource(conn,ps,rs);
        }
        return null;
    }

    //通用的增删改代码
    public static boolean updateall(String sql, Object ...args){
        //1、获取连接
                Connection conn = null;
                PreparedStatement ps = null;
                boolean b = false;
                try {
                    conn = DBUtil.getConnection();
                    //2、预编译SQL语句
                    ps = conn.prepareStatement(sql);
                    //3、填充占位符
                    for (int i = 0; i < args.length; i++) {
                        ps.setObject(i+1,args[i]);
                    }
                    //4、执行
                    if(ps.executeUpdate()>0){
                        b=true;
            }
            System.out.println("b1 = " + b);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5、关闭
            DBUtil.closeResource(conn,ps);
        }
        return b;
    }


}
