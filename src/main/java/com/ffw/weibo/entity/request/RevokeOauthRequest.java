package com.ffw.weibo.entity.request;

import com.ffw.weibo.tools.RequestField;

/**
 * 取消授权请求
 * Created by henrybit on 2017/3/17.
 * @version 1.0
 */
public class RevokeOauthRequest extends BaseRequest{
    @RequestField(name="access_token")
    protected String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
