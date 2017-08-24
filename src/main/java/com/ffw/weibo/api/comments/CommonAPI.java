package com.ffw.weibo.api.comments;

import com.ffw.weibo.api.BaseAPI;
import com.ffw.weibo.entity.URLConstant;
import com.ffw.weibo.entity.request.*;
import com.ffw.weibo.entity.response.BaseResponse;
import com.ffw.weibo.entity.response.GetUidResponse;
import com.ffw.weibo.tools.JSONTools;
import com.ffw.weibo.tools.RequestTools;
import org.apache.http.NameValuePair;

import java.util.HashMap;
import java.util.List;

/**
 * 公共API
 * Created by henrybit on 2017/3/18.
 * @version 1.0
 */
public class CommonAPI extends BaseAPI{

    /**
     *通过地址编码获取地址名称
     * @param request
     * @return List<HashMap<String, String>>
     */
    public static List<HashMap<String, String>> codeToLocation(CodeToLocationRequest request) {
        if (request == null) return null;
        List<NameValuePair> pairList = RequestTools.getRequestParams(request);
        BaseResponse response = httpTools.post(URLConstant.API_CODE_TO_LOCATION, pairList);
        if (response != null) {
            List<HashMap<String, String>> list = JSONTools.parserJson(response.getBody(), List.class);
            return list;
        }
        return null;
    }

    /**
     * 获取城市集合
     * @param request
     * @return list
     */
    public static List<HashMap<String, String>> getCitys(GetCityRequest request) {
        if (request == null) return null;
        List<NameValuePair> pairList = RequestTools.getRequestParams(request);
        BaseResponse response = httpTools.post(URLConstant.API_GET_CITY, pairList);
        if (response != null) {
            List<HashMap<String, String>> list = JSONTools.parserJson(response.getBody(), List.class);
            return list;
        }
        return null;
    }

    /**
     * 获取省份集合
     * @param request
     * @return list
     */
    public static List<HashMap<String, String>> getProvinces(GetProvinceRequest request) {
        if (request == null) return null;
        List<NameValuePair> pairList = RequestTools.getRequestParams(request);
        BaseResponse response = httpTools.post(URLConstant.API_GET_PROVINCE, pairList);
        if (response != null) {
            List<HashMap<String, String>> list = JSONTools.parserJson(response.getBody(), List.class);
            return list;
        }
        return null;
    }

    /**
     * 获取国家集合
     * @param request
     * @return list
     */
    public static List<HashMap<String, String>> getCountrys(GetCountryRequest request) {
        if (request == null) return null;
        List<NameValuePair> pairList = RequestTools.getRequestParams(request);
        BaseResponse response = httpTools.post(URLConstant.API_GET_COUNTRY, pairList);
        if (response != null) {
            List<HashMap<String, String>> list = JSONTools.parserJson(response.getBody(), List.class);
            return list;
        }
        return null;
    }

    /**
     * 获取时区配置Map
     * @param request
     * @return map
     */
    public static HashMap<String, String> getTimezones(GetTimezoneRequest request) {
        if (request == null) return null;
        List<NameValuePair> pairList = RequestTools.getRequestParams(request);
        BaseResponse response = httpTools.post(URLConstant.API_GET_TIMEZONE, pairList);
        if (response != null) {
            HashMap<String, String> map = JSONTools.parserJson(response.getBody(), HashMap.class);
            return map;
        }
        return null;
    }
}
