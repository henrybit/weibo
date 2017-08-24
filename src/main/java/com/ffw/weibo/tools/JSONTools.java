package com.ffw.weibo.tools;

import com.alibaba.fastjson.JSON;
import com.ffw.weibo.entity.response.GetTokenInfoResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * JSON工具类<br>
 * Created by henrybit on 2016/11/29.
 * @version 1.0
 */
public class JSONTools {
    private final static Gson gson = new Gson();

    /**
     * 指定对象转换成JSON数据<br>
     * Obj To json
     * @param obj
     * @return String
     */
    public static String toJson(Object obj) {
        if (obj == null)
            return "";
        return gson.toJson(obj);
    }

    /**
     * JSON转换成指定的对象(gson)<br>
     * json To T
     * @param json
     * @param cls
     * @param <T>
     * @return T
     */
    public static <T> T parserJson(String json, Class<T> cls) {
        if (StringTools.isEmpty(json))
            return null;
        return gson.fromJson(json, cls);
    }

    /**
     * JSON转成指定对象(gson)
     * @param json
     * @param typeOfT
     * @param <T>
     * @return
     */
    public static <T> T parserJson(String json, Type typeOfT) {
        if (StringTools.isEmpty(json))
            return null;
        return gson.fromJson(json, typeOfT);
    }

    /**
     * JSON转成指定对象(fastjson-支持JsonField)
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class<T> cls) {
        if (StringTools.isEmpty(json))
            return null;
        return JSON.parseObject(json, cls);
    }

    /**
     * 对象转成JSON格式(fastjson-支持JsonFiled)
     * @param obj
     * @return
     */
    public static String tofastJson(Object obj) {
        if (obj == null)
            return "";
        return JSON.toJSONString(obj);
    }

    public static void main(String[] args) {
        String json = " {\"uid\": 1073880650,\"appkey\": 1352222456,\"scope\": null,\"create_at\": 1352267591,\"expire_in\": 157679471 }";
        GetTokenInfoResponse response = JSONTools.parserJson(json, GetTokenInfoResponse.class);
        System.out.println(JSONTools.toJson(response));

        response = JSONTools.fromJson(json, GetTokenInfoResponse.class);
        System.out.println(JSONTools.tofastJson(response));
    }
}
