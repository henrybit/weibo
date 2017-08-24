package com.ffw.weibo.entity.request;

import com.ffw.weibo.tools.RequestField;

/**
 * 获取邮箱信息
 必选	类型及范围	说明
 access_token	true	string	采用OAuth授权方式为必填参数，OAuth授权后获得。
 * Created by henrybit on 2017/3/17.
 * @version 1.0
 */
public class GetEmailRequest extends BaseRequest{
    @RequestField(name="access_token")
    protected String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
