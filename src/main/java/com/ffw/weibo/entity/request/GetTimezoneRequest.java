package com.ffw.weibo.entity.request;

import com.ffw.weibo.tools.RequestField;

/**
 * 获取时区配置
 必选	类型及范围	说明
 access_token	true	string	采用OAuth授权方式为必填参数，OAuth授权后获得。
 language	false	string	返回的语言版本，zh-cn：简体中文、zh-tw：繁体中文、english：英文，默认为zh-cn。
 * Created by henrybit on 2017/3/18.
 * @version 1.0
 */
public class GetTimezoneRequest extends BaseRequest{
    @RequestField(name="access_token")
    protected String accessToken;
    @RequestField(name="language")
    protected String language;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
