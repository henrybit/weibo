package com.ffw.weibo.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * oauth1转oauth2的返回报文
 * Created by henrybit on 2017/3/17.
 * @version 1.0
 */
public class Oauth1TOauth2Response extends BaseResponse{
    @JSONField(name="access_token")
    protected String accessToken;
    @JSONField(name="expires_in")
    protected long expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
