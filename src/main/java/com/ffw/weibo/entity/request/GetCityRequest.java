package com.ffw.weibo.entity.request;

import com.ffw.weibo.tools.RequestField;

/**
 * 获取城市集合请求
 必选	类型及范围	说明
 access_token	true	string	采用OAuth授权方式为必填参数，OAuth授权后获得。
 province	true	string	省份的省份代码。
 capital	false	string	城市的首字母，a-z，可为空代表返回全部，默认为全部。
 language	false	string
 * Created by henrybit on 2017/3/18.
 * @version 1.0
 */
public class GetCityRequest extends BaseRequest{
    @RequestField(name="access_token")
    protected String accessToken;
    @RequestField(name="province")
    protected String province;
    @RequestField(name="capital")
    protected String capital;
    @RequestField(name="language")
    protected String language;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
