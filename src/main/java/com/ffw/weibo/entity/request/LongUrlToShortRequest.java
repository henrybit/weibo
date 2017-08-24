package com.ffw.weibo.entity.request;

import com.ffw.weibo.tools.RequestField;

/**
 * 长连接转短连接
 必选	类型及范围	说明
 access_token	true	string	采用OAuth授权方式为必填参数，OAuth授权后获得。
 url_long	true	string	需要转换的长链接，需要URLencoded，最多不超过20个。
 * Created by henrybit on 2017/3/18.
 */
public class LongUrlToShortRequest extends BaseRequest{
    @RequestField(name="access_token")
    protected String accessToken;
    @RequestField(name="url_long")
    protected String urlLong;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUrlLong() {
        return urlLong;
    }

    public void setUrlLong(String urlLong) {
        this.urlLong = urlLong;
    }
}
