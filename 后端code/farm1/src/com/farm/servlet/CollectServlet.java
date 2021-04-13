package com.farm.servlet;

import com.farm.util.JsonUtil;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/CollectServlet/*")
public class CollectServlet extends BaseServlet{

    /**
     * 8 收藏
     * @param request
     * @param response
     * @throws IOException
     */
    public void insertCollect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("userName");
        int productID = Integer.parseInt(request.getParameter("productID"));
        int id = userDAO.getId(name);
        if(id !=0 && productDao.get(productID) != null){
            collectDao.add(productID, id);
        }
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        String s;
        Map<String, Object> m = JsonUtil.toSuccessMap();
        m.put("code",200);
        m.put("message","访问成功");
        s = gson.toJson(m);
        out.write(s);
        out.flush();
        out.close();
    }
}
