package com.farm.test;

import com.farm.bean.Product;
import com.farm.dao.CategoryDao;
import com.farm.dao.PictureDao;
import com.farm.dao.ProductDao;
import com.farm.readJson.CategoryJson;
import com.farm.util.JsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class toJsonTest {

    public static void main(String[] args) {
        //categoryTest();
        productTest();
    }
    /**
     * 1-首页商品展示接口
     * 为页面的每个一级分类获取，十个热门商品。
     * 思路：1.通过List<CategoryName> list查找相对应的CategoryID
     * 2.通过CategoryID在Product表中查找相应的Product
     * map1(code,200);
     *map1.put(data,list1);
     * list1.add();
     * list1.add();
     *
     * map("ProductID":1);
     * list.add(map);
     * map1("ProductArray",list);
     * map1("CategoryName":"禽畜肉蛋");
     * list1.add(map1);
     * map2(data,list1)
     */
    public static void categoryTest(){
        ProductDao productDao = new ProductDao();
        CategoryDao categoryDao = new CategoryDao();
        PictureDao pictureDao = new PictureDao();
        //1.通过List<CategoryName> list查找相对应的CategoryID,DaoTest的解析过程的调用
        List<CategoryJson> categoryJsons = DaoTest.idea2();
        ArrayList productArray = new ArrayList();

        System.out.println("categoryJsons.get(i).getCategoryName() = " + categoryJsons.get(0).getCategoryName());

        ArrayList<Object> list1 = new ArrayList<>();
        for (int i=0; i<categoryJsons.size();i++) {
            List<Product> products = productDao.getTen(categoryDao.getId(categoryJsons.get(i).getCategoryName()));
            Map<String, Object> map1=new HashMap<>();
            ArrayList<Object> list = new ArrayList<>();
            for(int j=0; j<10;j++){
                Map<String, Object> map=new HashMap<>();
                map.put("ProductID",products.get(j).getProductID());
                map.put( "ProductName",products.get(j).getProductName());
                map.put("Title",products.get(j).getTitle());
                map.put("UnitPrice",products.get(j).getUnitPrice());
                map.put("Stock",products.get(j).getStock());
                map.put("image",pictureDao.get(products.get(j).getProductID()));  //暂时定下
                list.add(map);
                System.out.println("map = " + map);
            }
            map1.put("CategoryName",categoryJsons.get(i).getCategoryName());
            map1.put("ProductArray",list);
            list1.add(map1);
            System.out.println("list1 = " + list1);
        }
        Map<String, Object> map2 = JsonUtil.toSuccessMap();
        map2.put("data",list1);
        System.out.println("map2 = " + map2);
    }

    public static void productTest(){
        ProductDao productDao = new ProductDao();
        CategoryDao categoryDao = new CategoryDao();
        PictureDao pictureDao = new PictureDao();
        int type=2;
        String key = "果";
        int page = 1;
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
        }
        int pageEnd = (page*20)>products.size() ? products.size()-(page-1)*20 : page*20 ;
        System.out.println("pageEnd = " + pageEnd);
        for (int i = 20*(page-1); i < pageEnd; i++) {
            Map<String, Object> map=new HashMap<>();
            map.put("productID",products.get(i).getProductID());
            map.put( "productName",products.get(i).getProductName());
            map.put("title",products.get(i).getTitle());
            map.put("unitPrice",products.get(i).getUnitPrice());
            map.put("stock",products.get(i).getStock());
            map.put("image",pictureDao.get(products.get(i).getProductID()).get(0).getPictureaddress());  //暂时定下
            productList.add(map);
            System.out.println("map = " + map);
        }
        data.put("product",productList);
        Map<String, Object> successMap = JsonUtil.toSuccessMap();
        successMap.put("data",data);
    }

}
