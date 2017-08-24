package com.ffw.weibo.entity.request;

import com.ffw.weibo.tools.RequestField;

/**
 * 获取当前登录用户的API访问频率限制情况
 必选	类型及范围	说明
 access_token	true	string	采用OAuth授权方式为必填参数，OAuth授权后获得。
 * Created by henrybit on 2017/3/17.
 * @version 1.0
 */
public class RateLimitStatusRequest extends BaseRequest{
    @RequestField(name="access_token")
    protected String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
