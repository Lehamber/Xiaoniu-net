package com.farm.servlet;
import com.farm.bean.AttributeValue;
import com.farm.dao.*;
import com.google.gson.internal.$Gson$Preconditions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public abstract class BaseServlet extends HttpServlet{

    protected AttributeValueDao attributeValueDao = new AttributeValueDao();
    protected OrderDao orderDao = new OrderDao();
    protected ProductDao productDao = new ProductDao();
    protected AddressDao addressDao = new AddressDao();
    protected AttributeDao attributeDao = new AttributeDao();
    protected CategoryDao categoryDao = new CategoryDao();
    protected CollectDao collectDao = new CollectDao();
    protected EvaluationDao evaluationDao = new EvaluationDao();
    protected GenetrationDao genetrationDao = new GenetrationDao();
    protected PictureDao pictureDao = new PictureDao();
    protected UsersDao userDAO = new UsersDao();

    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        System.out.println("方法被执行了");
        //res.setCharacterEncoding("UTF-8");
        //res.setHeader("content-type", "text/json");
        /* 允许跨域的主机地址 */
        res.setHeader("Access-Control-Allow-Origin", "*");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        res.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        //res.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        res.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        res.setHeader("Access-Control-Allow-Credentials", "true");
        /*还需要设置允许OPTIONS请求*/
        /*if ("OPTIONS".equals(req.getMethod())) {
            res.setStatus(HttpStatus.SC_OK);
        }*/

        // 获取路径
         String requestURI = req.getRequestURI();
         StringBuffer requestURL = req.getRequestURL();
         System.out.println("requestURI:"+requestURI+"  requestURL:"+requestURL); // requestURI:/user/da  requestURL:http://localhost/user/da
         // 截取
         String methonName = requestURI.substring(requestURI.lastIndexOf("/")+1); //
         System.out.println(methonName); // da

         System.out.println(this);  // cn.itcast.travel.servlet.UserServlet@3599a2d1

         // 分发

         try {
                 // 获取方法
                 //Method declaredMethod = this.getClass().getMethod(methonName, HttpServletRequest.class, HttpServletResponse.class);
                 // 忽略访问权限修饰，获取方法
                   Method declaredMethod = this.getClass().getDeclaredMethod(methonName, HttpServletRequest.class, HttpServletResponse.class);
                 //暴力反射
                   declaredMethod.setAccessible(true);

                 // 执行方法
                 declaredMethod.invoke(this,req,res);

             } catch (NoSuchMethodException e) {
                 e.printStackTrace();
             } catch (IllegalAccessException e) {
                 e.printStackTrace();
             } catch (InvocationTargetException e) {
                 e.printStackTrace();
             }
/*
        String requestURI = req.getRequestURI();
        // 截取
        String methonName = requestURI.substring(requestURI.lastIndexOf("/")+1); //
        System.out.println(methonName); // da

        // 1、获得执行的方法名
        String methodName = req.getParameter("method");
        // 默认方法
        if (methodName == null) {
            methodName = "execute";
        }

        System.out.println("BaseServlet : 本次所执行方法 :  " + methodName);

        try {
            // 2、通过反射获得当前运行类中指定方法,形式参数
            Method executeMethod = this.getClass().getMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);
            // 3、反射执行方法
            String result = (String) executeMethod.invoke(this, req,
                    res);
            // 4、将json数据返回
            res.getWriter().write(result);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("未知方法  : " + methodName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("服务器异常", e);
        }*/
    }

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
