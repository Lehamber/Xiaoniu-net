package com.farm.servlet;

import com.alibaba.fastjson.JSON;
import com.farm.bean.Category;
import com.farm.bean.Product;
import com.farm.readJson.CategoryJson;
import com.farm.test.DaoTest;
import com.farm.util.JsonUtil;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/categoryServlet/*")
public class CategoryServlet extends BaseServlet{

    /**
     * 1.首页展示
     * @param request
     * @param response
     */
    public void showCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String json = JsonUtil.readJsonData(request);
        System.out.println("json = " + json);
        JsonObject asJsonObject = new JsonParser().parse(json).getAsJsonObject();
        JsonArray data = asJsonObject.getAsJsonArray("data");
        Gson gson = new Gson();
        ArrayList<CategoryJson> list3 = new ArrayList<>();
        for (JsonElement category:data) {
                CategoryJson bean = gson.fromJson(category, new TypeToken<CategoryJson>() {}.getType());
                list3.add(bean);
        }
        //1.通过List<CategoryName> list查找相对应的CategoryID,DaoTest的解析过程的调用
        List<CategoryJson> categoryJsons = list3;
        ArrayList<Object> list1 = new ArrayList<>();
        for (int i=0; i<categoryJsons.size();i++) {
            List<Product> products = productDao.getTen(categoryDao.getId(categoryJsons.get(i).getCategoryName()));
            Map<String, Object> map1=new HashMap<>();
            ArrayList<Object> list = new ArrayList<>();
            for(int j=0; j<10;j++){
                Map<String, Object> map=new HashMap<>();
                map.put("productID",products.get(j).getProductID());
                map.put( "productName",products.get(j).getProductName());
                map.put("title",products.get(j).getTitle());
                map.put("unitPrice",products.get(j).getUnitPrice());
                map.put("stock",products.get(j).getStock());
                map.put("image",pictureDao.get(products.get(j).getProductID()).get(0).getPictureaddress());  //暂时定下
                list.add(map);
                //System.out.println("map = " + map);
            }
            map1.put("categoryName",categoryJsons.get(i).getCategoryName());
            map1.put("productArray",list);
            list1.add(map1);
            //System.out.println("list1 = " + list1);
        }
        Map<String, Object> map2 = JsonUtil.toSuccessMap();
        map2.put("data",list1);
        System.out.println("map2 = " + map2);
        PrintWriter out = response.getWriter();
        String s = gson.toJson(map2);
        out.write(s);
        out.flush();
        out.close();

    }
    /*public void showCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String jsonData = JsonUtil.readJsonData(request);
        System.out.println("jsonData = " + jsonData);
        JsonObject asJsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
        JsonArray data = asJsonObject.getAsJsonArray("data");
        Gson gson = new Gson();
        ArrayList<CategoryJson> list3 = new ArrayList<>();
        for (JsonElement category:data
        ) {
            CategoryJson bean = gson.fromJson(category, new TypeToken<CategoryJson>() {
            }.getType());
            list3.add(bean);
        }
        System.out.println("list = " + list3);
        //1.通过List<CategoryName> list查找相对应的CategoryID,DaoTest的解析过程的调用
        List<CategoryJson> categoryJsons = DaoTest.idea2();
        ArrayList<Object> list1 = new ArrayList<>();
        for (int i=0; i<categoryJsons.size();i++) {
            List<Product> products = productDao.getTen(categoryDao.getId(categoryJsons.get(i).getCategoryName()));
            Map<String, Object> map1=new HashMap<>();
            ArrayList<Object> list = new ArrayList<>();
            for(int j=0; j<2;j++){
                Map<String, Object> map=new HashMap<>();
                map.put("productID",products.get(j).getProductID());
                map.put( "productName",products.get(j).getProductName());
                map.put("title",products.get(j).getTitle());
                map.put("unitPrice",products.get(j).getUnitPrice());
                map.put("stock",products.get(j).getStock());
                map.put("image",pictureDao.get(products.get(j).getProductID()).get(1));  //暂时定下
                list.add(map);
                System.out.println("map = " + map);
            }
            map1.put("categoryName",categoryJsons.get(i).getCategoryName());
            map1.put("productArray",list);
            list1.add(map1);
            System.out.println("list1 = " + list1);
        }
        Map<String, Object> map2 = JsonUtil.toSuccessMap();
        map2.put("data",list1);
        System.out.println("map2 = " + map2);
        PrintWriter out = response.getWriter();
        String s = gson.toJson(map2);
        out.write(s);
        out.flush();
        out.close();
    }

    */
    //4-查询 关键字 类型，属于哪一级分类
    public void keyType(HttpServletRequest request, HttpServletResponse response) throws IOException
       {
        String key = request.getParameter("key");
        int type=0;
        if (categoryDao.getId(key)!=0){
            //属于一级分类 type=1
            type=1;
        }else if (productDao.getSome(key).size()!=0){
            System.out.println("productDao.getSome(key) = " + productDao.getSome(key));
            type=2;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("type",type);

        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        String s;
        Map<String, Object> m = JsonUtil.toSuccessMap();
        m.put("code",200);
        m.put("message","访问成功");
        m.put("data",map);
        s = gson.toJson(m);
        out.write(s);
        out.flush();
        out.close();
    }
   public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        boolean var3 = false;

        int len;
        while((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }

       outSteam.close();
       inStream.close();
       /*StringBuffer json = new StringBuffer();
       String lineString = null;
       try {
           BufferedReader reader = request.getReader();
           while ((lineString=reader.readLine()) != null){
               json.append(lineString);
           }
       } catch (IOException e) {
           System.out.println(e.toString());
       }*/
       return outSteam.toByteArray();
   }

    /**7777
     * 1.通过产品名查询类型id
     * 2.通过类型id查询类型名
     * @param request
     * @param response
     */
   public void returnKey(HttpServletRequest request, HttpServletResponse response) throws IOException {
       String key = request.getParameter("key");
       Map<String, Object> map = JsonUtil.toSuccessMap();
       Map<String, Object> map1=new HashMap<>();
       Gson gson = new Gson();
       PrintWriter out = response.getWriter();
       String s;

       if(productDao.getCategoryID(key) != 0){
           map1.put("key",categoryDao.getOne(productDao.getCategoryID(key)).getCategoryName());
           map.put("data",map1);
       }else{
           map.put("data","");
       }
       s = gson.toJson(map);
       out.write(s);
       out.flush();
       out.close();
   }
}
