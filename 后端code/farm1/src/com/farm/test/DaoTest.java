package com.farm.test;

import com.farm.bean.*;
import com.farm.dao.*;
import com.farm.readJson.CategoryJson;
import com.farm.util.JsonUtil;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.PrintWriter;
import java.util.*;

public class DaoTest {
     AttributeValueDao attributeValueDao = new AttributeValueDao();
     OrderDao orderDao = new OrderDao();
     static ProductDao  productDao = new ProductDao();
     AddressDao addressDao = new AddressDao();
     AttributeDao attributeDao = new AttributeDao();
     static CategoryDao categoryDao = new CategoryDao();
     CollectDao collectDao = new CollectDao();
     EvaluationDao evaluationDao = new EvaluationDao();
     GenetrationDao genetrationDao = new GenetrationDao();
    static PictureDao pictureDao = new PictureDao();
     UsersDao userDAO = new UsersDao();

    public static void main(String[] args) {
        /*UsersDao userDAO = new UsersDao();
        Map<String, Object> map = new HashMap<>();
            Users users = userDAO.get("李峰");
            System.out.println("users = " + users.getBusinessName());
            if (users.getBusinessType()>0){
                map.put("haveBusiness",1);
            }else{
                map.put("haveBusiness",0);
            }
        System.out.println("map = " + map);*/
        //new DaoTest().test4();
        //categoryTest();
        //test1();
        //productest();
        //idea2();
    }

    /**
     * 含有数据头的纯数组
     */
    public static List<CategoryJson> idea2(){
        /*String jsonData = "{\n \"data\":[\n" +
                "    {\n" +
                "        \"CategoryName\": \"农资农机\"\n" +"},\n" +
                "    {\n" +
                "        \"CategoryName\": \"水果\"\n" +"}\n" +
                "]}";*/
        String jsonData = "{\n \"data\":[\n" +
                "    {\n" +
                "        \"categoryName\": \"农资农机\"\n" +"}\n" +
                "]}";
        System.out.println("jsonData = " + jsonData);
        JsonObject asJsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
        JsonArray data = asJsonObject.getAsJsonArray("data");
        Gson gson = new Gson();
        ArrayList<CategoryJson> list = new ArrayList<>();
        for (JsonElement category:data
        ) {
            CategoryJson bean = gson.fromJson(category, new TypeToken<CategoryJson>() {
            }.getType());
            //System.out.println("bean = " + bean);
            list.add(bean);
        }
        //System.out.println("list = " + list);

        return list;
    }
    //纯数组
    public void idea(){
        String jsonData = "[\n" +
                "    {\n" +
                "        \"CategoryName\": \"中国\"\n" +"},\n" +
                "    {\n" +
                "        \"CategoryName\": \"加拿大\"\n" +"}\n" +
                "]";
        Gson gson = new Gson();
        ArrayList<CategoryJson> jsons = JsonUtil.jsonToArrayList(jsonData, CategoryJson.class);
        System.out.println("jsons2 = " + jsons.get(1));
        System.out.println("jsons1 = " + jsons.get(0).getCategoryName());
        System.out.println("jsons2 = " + jsons.get(1).getCategoryName());

    }

    public static void categoryTest(){
        CategoryDao dao = new CategoryDao();
        int id = dao.getId("水果");
        System.out.println("id = " + id);
    }
    public static void productest(){
        ProductDao dao = new ProductDao();
        //System.out.println(dao.get(1));
        List<Product> ten = dao.getTen(1);
        System.out.println("ten = " + ten);
        //dao.getSome("1");
        //Date date = new Date();
        //Date date1 = new Date();
        //      boolean b = dao.add("111", "111", 3, 3, date, date1, 2, "按斤");
        //System.out.println("b = " + b);
    }
    public static void test1(){
        UsersDao usersDao = new UsersDao();
        //Users users = usersDao.get("张", "123456");
        //usersDao.get()
        //usersDao.add("yiyi","111111");

        //System.out.println("users-------->"+usersDao.delete("王五"));
        System.out.println("usersDao = " + usersDao.getEmail("123456789@qq.com"));
        System.out.println("usersDao = " + usersDao.getUserPhone("18211111111"));
    }

    public  void test2(){
        int productID = 1;
        Product product = productDao.get(productID);
        Users users = userDAO.get(product.getUserID());
        List<Attribute> attributeList = attributeDao.getSome(product.getCategoryID());

        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < attributeList.size(); i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("Attributename",attributeList.get(i).getAttributeName());
            map.put("value", attributeValueDao.getDetail(attributeList.get(i).getAttributeID(),productID).getValue());
            list.add(map);
        }
        System.out.println("list = " + list);

        List<Evaluation> evaluations = evaluationDao.get(productID);
        ArrayList<Object> list1 = new ArrayList<>();
        for (int i = 0; i < evaluations.size(); i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("userPhoto",userDAO.get(evaluations.get(i).getUserID()).getUserphoto());
            map.put("userName",userDAO.get(evaluations.get(i).getUserID()).getUserName());
            map.put("evaluationDate",evaluations.get(i).getEvaluationDate());
            map.put("content",evaluations.get(i).getCount());
            list1.add(map);
        }
        System.out.println("list1 = " + list1);

        List<Picture> list2 = pictureDao.get(productID);
        Map<String, Object> map = new HashMap<>();
        map.put("imageArray", list2);
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

        Map<String, Object> toSuccessMap = JsonUtil.toSuccessMap();
        toSuccessMap.put("data",map);
        System.out.println("toSuccessMap = " + toSuccessMap);

    }

    public void test3(){
        System.out.println("attributeValueDao = " + attributeValueDao.getDetail(1,1));
    }
    public void test4(){
        String key = "红薯";
        int type=0;
        if (categoryDao.getId(key)!=0){
            //属于一级分类 type=1
            type=1;
        }else if (productDao.getSome(key) != null){
            type=2;
        }
        System.out.println("type = " + type);
        HashMap<String, Object> map = new HashMap<>();
        map.put("type",type);
        Map<String, Object> m = JsonUtil.toSuccessMap();
        m.put("data",map);
        System.out.println("m = " + m);
    }



}
