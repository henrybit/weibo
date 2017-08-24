package com.ffw.weibo.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by henrybit on 2017/3/17.
 * @version 1.0
 */
public class GetEmailResponse extends BaseResponse{
    @JSONField(name="email")
    protected String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
