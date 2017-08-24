package com.ffw.weibo.entity.request;

import com.ffw.weibo.tools.RequestField;

/**
 * 获取省份请求
 必选	类型及范围	说明
 access_token	true	string	采用OAuth授权方式为必填参数，OAuth授权后获得。
 country	true	string	国家的国家代码。
 capital	false	string	省份的首字母，a-z，可为空代表返回全部，默认为全部。
 language	false	string	返回的语言版本，zh-cn：简体中文、zh-tw：繁体中文、english：英文，默认为zh-cn。
 * Created by henrybit on 2017/3/18.
 */
public class GetProvinceRequest extends BaseRequest{
    @RequestField(name="access_token")
    protected String accessToken;
    @RequestField(name="country")
    protected String country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
