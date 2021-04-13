package com.farm.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonUtil {

    public static String readJsonData(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf8");
        StringBuffer json = new StringBuffer();
        String lineString = null;
        try {
            BufferedReader reader = request.getReader();
            while ((lineString=reader.readLine()) != null){
                //lineString = new String(lineString.getBytes(), "utf-8");
                json.append(lineString);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return json.toString();
    }
    //单个json对象
    public static Object getInstanceByJson(Class<?> clazz, String json)
    {
        Object obj = null;
        Gson gson = new Gson();
        obj = gson.fromJson(json, clazz);
        return obj;
    }
    //ArrayList
    public static <T> ArrayList<T> jsonToArrayList(String json, Class<T> clazz)
    {
        Type type = new TypeToken<ArrayList<JsonObject>>()
        {}.getType();
        ArrayList<JsonObject> jsonObjects = new Gson().fromJson(json, type);

        ArrayList<T> arrayList = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects)
        {
            arrayList.add(new Gson().fromJson(jsonObject, clazz));
        }
        return arrayList;
    }
    //转为map
    public static Map<String,Object> toSuccessMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("message","处理成功");
        return map;
    }
    public static Map<String,Object> toFailMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("message","处理成功");
        return map;
    }
    public static void last(Map<String,Object> map){

    }
}
