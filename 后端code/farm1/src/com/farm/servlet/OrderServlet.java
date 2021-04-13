package com.farm.servlet;

import com.farm.bean.Order;
import com.farm.util.JsonUtil;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/OrderServlet/*")
public class OrderServlet extends BaseServlet{
    /**
     * 提交订单
     */
    public void submitOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        String userName = request.getParameter("userName");
        String bussinessName = request.getParameter("bussinessName");
        int addressID = Integer.parseInt(request.getParameter("addressID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        BigDecimal orderMoney = new BigDecimal(Double.parseDouble((request.getParameter("orderMoney"))));
        Date date = orderDao.add(productID, new Date(), addressID, orderMoney, quantity);
        Map<String,Object> map = new HashMap<>();
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        Map<String, Object> m = JsonUtil.toSuccessMap();
        m.put("code",200);
        m.put("message","访问成功");
        if(date != null){
            Order orderId = orderDao.getOrderId(date);
            map.put("orderID",orderId);
            m.put("data",map);
        }else{
            m.put("data","");
        }
        String s = gson.toJson(m);
        out.write(s);
        out.flush();
        out.close();
    }
        /**
         * 10- 确认订单页 查询
         */
    public void confirmOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("userName");
        int productID = Integer.parseInt(request.getParameter("productID"));



    }

}
