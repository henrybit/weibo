package com.ffw.weibo.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 取消授权返回报文
 * Created by henrybit on 2017/3/17.
 * @version 1.0
 */
public class RevokeOauthResponse extends BaseResponse{
    @JSONField(name="result")
    protected String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
