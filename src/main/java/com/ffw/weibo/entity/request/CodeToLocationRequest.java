package com.ffw.weibo.entity.request;

import com.ffw.weibo.tools.RequestField;

/**
 *通过地址编码获取地址名称
 必选	类型及范围	说明
 access_token	true	string	采用OAuth授权方式为必填参数，OAuth授权后获得。
 codes	true	string	需要查询的地址编码，多个之间用逗号分隔。
 * Created by henrybit on 2017/3/18.
 */
public class CodeToLocationRequest extends BaseRequest{
    @RequestField(name="access_token")
    protected String accessToken;
    @RequestField(name="codes")
    protected String codes;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }
}
