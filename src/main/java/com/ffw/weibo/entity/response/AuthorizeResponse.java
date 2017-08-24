package com.ffw.weibo.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 授权请求的Code
 * Created by henrybit on 2017/3/17.
 * @version 1.0
 */
public class AuthorizeResponse extends BaseResponse{
    @JSONField(name="state")
    protected String state;
    @JSONField(name="code")
    protected String code;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
