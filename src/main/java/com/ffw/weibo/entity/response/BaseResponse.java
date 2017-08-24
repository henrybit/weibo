package com.ffw.weibo.entity.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.ffw.weibo.tools.JSONTools;

/**
 * 基本返回报文
 * Created by henrybit on 2017/3/9.
 * @version 1.0
 */
public class BaseResponse {
    //返回报文内容
    @JSONField(name="body")
    private String body;
    //返回状态
    @JSONField(name="httpCode")
    private int httpCode;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    @Override
    public String toString() {
        return JSONTools.toJson(this);
    }
}
