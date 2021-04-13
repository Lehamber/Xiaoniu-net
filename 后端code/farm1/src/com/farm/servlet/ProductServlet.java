package com.farm.servlet;

import com.farm.bean.*;
import com.farm.util.JsonUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.apache.commons.lang.ArrayUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/productServlet/*")
public class ProductServlet extends BaseServlet {

    /**
     * 3-搜索框模糊查询接口
     */
    public void fuzzyQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String key = request.getParameter("key");
        List<Product> products0 = productDao.getSome(key);
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < products0.size(); i++) {
            set.add(products0.get(i).getProductName());
        }
        List<String> products = new ArrayList<>(set);
        ArrayList<Object> list = new ArrayList<>();
        int len = products.size()<10 ? products.size() : 10;
        for (int i=0; i<len; i++){
            Map<String, Object> productMap = new HashMap<>();
            productMap.put("productName",products.get(i));
            list.add(productMap);
        }
        Map<String, Object> map = JsonUtil.toSuccessMap();
        map.put("data",list);
        Gson gson = new Gson();
        String s = gson.toJson(map);
        PrintWriter out = response.getWriter();
        out.write(s);
        out.flush();
        out.close();
    }
    //6-具体商品查询接口
    public void productMes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        Map<String, Object> map;
        Map<String, Object> toSuccessMap = JsonUtil.toSuccessMap();
        Product product = productDao.get(productID);
        if(product != null){
            Users users = userDAO.get(product.getUserID());
            List<Attribute> attributeList = attributeDao.getSome(product.getCategoryID());
            ArrayList<Object> list = new ArrayList<>();
            for (int i = 0; i < attributeList.size(); i++) {
                HashMap<String, Object> map1 = new HashMap<>();
                map1.put("Attributename",attributeList.get(i).getAttributeName());
                map1.put("value", attributeValueDao.getDetail(attributeList.get(i).getAttributeID(),productID).getValue());
                list.add(map1);
            }
            List<Evaluation> evaluations = evaluationDao.get(productID);
            ArrayList<Object> list1 = new ArrayList<>();
            if (evaluations.size()>0){
                for (int i = 0; i < evaluations.size(); i++) {
                    HashMap<String, Object> map1 = new HashMap<>();
                    map1.put("userPhoto",userDAO.get(evaluations.get(i).getUserID()).getUserphoto());
                    map1.put("userName",userDAO.get(evaluations.get(i).getUserID()).getUserName());
                    map1.put("evaluationDate",evaluations.get(i).getEvaluationDate());
                    map1.put("content",evaluations.get(i).getContent());
                    list1.add(map1);
                }
            }else {
                list1=null;
            }
            //System.out.println("list1 = " + list1);
            List<Picture> list2 = pictureDao.get(productID);
            ArrayList<Object> imgs = new ArrayList<>();
            for (int i = 0; i < list2.size(); i++) {
                imgs.add(list2.get(i).getPictureaddress());
            }
            map = new HashMap<>();
            map.put("imageArray", imgs);
            map.put("evaluationArray", list1);
            map.put("attributeArray", list);
            map.put("businessName",users.getBusinessName());
            map.put("orderAmount",orderDao.productcCount(productID));
            map.put("businessPhone",users.getBusinessphone());
            map.put("productID",productID);
            map.put("title",product.getTitle());
            map.put("updateDate",product.getUpdateDate());
            map.put("businessAddress",users.getBusinessAddress());
            map.put("unitPrice",product.getUnitPrice());
            map.put("stock",product.getStock());
            map.put( "evalutionCount",evaluations.size());
            map.put("specification",product.getSpecification());
            toSuccessMap.put("data",map);
        }else{
            map = new HashMap<>();
            toSuccessMap.put("data",map);
        }

        Gson gson = new Gson();
        String s = gson.toJson(toSuccessMap);
        PrintWriter out = response.getWriter();
        out.write(s);
        out.flush();
        out.close();
    }

    //5-关键字查询
    public void keyQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int type = Integer.parseInt(request.getParameter("type"));
        String key = request.getParameter("key");
        int page = Integer.parseInt(request.getParameter("page"));


        HashMap<String, Object> data = new HashMap<>();
        ArrayList<Object> productList = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        if (type==1){
            int categoryId = categoryDao.getId(key);
            int sum = productDao.count(categoryId);
            data.put("sum",sum);
            products = productDao.getTen(categoryId);
            System.out.println("products.size = " + products.size());
        }else if (type==2){
            products = productDao.getSome(key);
            data.put("sum",products.size());
            System.out.println("products.size = " + products.size());
        }else if (type==3){
            Set<Product> set = new HashSet<Product>();
            Random ran = new Random();
            while(set.size()<20){
                int i = ran.nextInt(119);
                System.out.println("i = " + i);
                if(productDao.get(i) != null){
                    set.add(productDao.get(i));
                }
            }
            products = new ArrayList<>(set);
            System.out.println("products.size() = " + products.size());
            data.put("sum",productDao.allCount());
        }
        int begin = products.size()/20;
        int last = products.size()/20+1;
        if(products.size()%20 == 0){
            begin-=1;
            last-=1;
        }
        int pageEnd=0;
        int pageBegin=0;
        if(type==3){
            pageEnd = 20;
            pageBegin = 0;
        }else if(page <= last){
            //int pageEnd1 = (page*20)>products.size() ? (-) : page*20 ;
            pageEnd = begin>=page ? 20*page : products.size();
            pageBegin=20*(page-1);
        }
        System.out.println("pageEnd = " + pageEnd);
        System.out.println("pageBegin = " + pageBegin);
        for (int i = pageBegin; i < pageEnd; i++) {
            Map<String, Object> map=new HashMap<>();
            map.put("productID",products.get(i).getProductID());
            map.put( "productName",products.get(i).getProductName());
            map.put("title",products.get(i).getTitle());
            map.put("unitPrice",products.get(i).getUnitPrice());
            map.put("stock",products.get(i).getStock());
            map.put("image",pictureDao.get(products.get(i).getProductID()).get(0).getPictureaddress());  //暂时定下
            productList.add(map);
            //System.out.println("map = " + map);
        }
        data.put("product",productList);
        Map<String, Object> successMap = JsonUtil.toSuccessMap();
        successMap.put("data",data);

        Gson gson = new Gson();
        String s = gson.toJson(successMap);
        PrintWriter out = response.getWriter();
        out.write(s);
        out.flush();
        out.close();
    }
}
