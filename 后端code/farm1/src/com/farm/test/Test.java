package com.farm.test;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.farm.bean.*;
import com.farm.dao.*;
import com.farm.util.DBUtil;
import com.farm.util.JsonUtil;
import com.farm.util.SqlUtil;

public class Test {
	protected AttributeValueDao attributeValueDao = new AttributeValueDao();
	protected static OrderDao orderDao = new OrderDao();
	protected static ProductDao productDao = new ProductDao();
	protected AddressDao addressDao = new AddressDao();
	protected AttributeDao attributeDao = new AttributeDao();
	protected static CategoryDao categoryDao = new CategoryDao();
	protected CollectDao collectDao = new CollectDao();
	protected static  EvaluationDao evaluationDao = new EvaluationDao();
	protected GenetrationDao genetrationDao = new GenetrationDao();
	protected static PictureDao pictureDao = new PictureDao();
	protected static UsersDao userDAO = new UsersDao();
	public static void main(String[] args) {
		//System.out.println("productDao.getCategoryID(\"花生\") = " + productDao.getCategoryID("花生"));
		//System.out.println("categoryDao.getOne(productDao.getCategoryID(\"\")).getCategoryName() = " + categoryDao.getOne(productDao.getCategoryID("花生")).getCategoryName());
		//System.out.println("evaluationDao.get(1) = " + evaluationDao.get(1));
		//new Test().test2();
		//test1();
		//new Test().test5();
		System.out.println("new Date() = " + new Date());
	}
	public void test5(){
		int categoryId = categoryDao.getId("蔬菜");
		int sum = productDao.count(categoryId);
		System.out.println("sum = " + sum);
		List<Product> products = new ArrayList<>();
		//data.put("sum",sum);
		products = productDao.getTen(categoryId);


		for (int i = 0; i < products.size(); i++) {
			System.out.println("products " + products.get(i).getProductID());
			//System.out.println(i+"img0 = " + pictureDao.get(products.get(i).getProductID()).get(0));
		}
	}
	public void test4(){
		int page=2;
		List<Product> products = new ArrayList<>();
		ArrayList<Object> productList = new ArrayList<>();
		HashMap<String, Object> data = new HashMap<>();
		products = productDao.getTen(categoryDao.getId("水果"));

		int begin = products.size()/20;
		int last = products.size()/20+1;
		if(page <= last){
			//int pageEnd1 = (page*20)>products.size() ? (-) : page*20 ;
			int pageEnd =products.size()-(page-1)*20;
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
		}

		//data.put("product",productList);
	}

	public void test3(){
		List<Evaluation> evaluations = evaluationDao.get(2);
		ArrayList<Object> list1 = new ArrayList<>();
		System.out.println("size = "+evaluations.size());
		if (evaluations.size()>0){
			for (int i = 0; i < evaluations.size(); i++) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("userPhoto",userDAO.get(evaluations.get(i).getUserID()).getUserphoto());
				map.put("userName",userDAO.get(evaluations.get(i).getUserID()).getUserName());
				map.put("evaluationDate",evaluations.get(i).getEvaluationDate());
				map.put("content",evaluations.get(i).getContent());
				list1.add(map);
			}
		}else {
			list1=null;
		}
		System.out.println("list1 = " + list1);
	}
	public  void test2(){
		int productID =1;
		Product product = productDao.get(1);
		Users users = userDAO.get(product.getUserID());
		List<Attribute> attributeList = attributeDao.getSome(product.getCategoryID());

		ArrayList<Object> list = new ArrayList<>();
		/*for (int i = 0; i < attributeList.size(); i++) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("Attributename",attributeList.get(i).getAttributeName());
			map.put("value", attributeValueDao.getDetail(attributeList.get(i).getAttributeID(),productID).getValue());
			list.add(map);
		}*/
		list=null;
		System.out.println("list = " + list);
		List<Evaluation> evaluations = evaluationDao.get(productID);
		ArrayList<Object> list1 = new ArrayList<>();
		if (evaluations.size()>0){
			for (int i = 0; i < evaluations.size(); i++) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("userPhoto",userDAO.get(evaluations.get(i).getUserID()).getUserphoto());
				map.put("userName",userDAO.get(evaluations.get(i).getUserID()).getUserName());
				map.put("evaluationDate",evaluations.get(i).getEvaluationDate());
				map.put("content",evaluations.get(i).getContent());
				list1.add(map);
			}
		}else {
			list1=null;
		}
		System.out.println("list1 = " + list1);
		List<Picture> list2 = pictureDao.get(productID);
		ArrayList<Object> imgs = new ArrayList<>();
		for (int i = 0; i < list2.size()-1; i++) {
			imgs.add(list2.get(i).getPictureaddress());
		}

		Map<String, Object> map = new HashMap<>();
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

		Map<String, Object> toSuccessMap = JsonUtil.toSuccessMap();
		toSuccessMap.put("data",map);
		System.out.println("toSuccessMap = " + toSuccessMap);
	}

	public static void test1() {
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from Users where userID = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 1);
			
			rs = ps.executeQuery();
			if(rs.next()){
				int id = (int)rs.getInt(1);
				String name = (String) rs.getObject(2);
				String pwd = (String) rs.getObject(3);
				String type = (String) rs.getObject(4);
				//Users user = new Users(id,name,pwd,type);
				//System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			DBUtil.closeResource(conn, ps, rs);
		}
		
		
	}

}
