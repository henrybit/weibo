package com.ffw.weibo.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 获取用户ID
 {
 "uid":"3456676543"
 }
 * Created by henrybit on 2017/3/17.
 * @version 1.0
 */
public class GetUidResponse extends BaseResponse{
    @JSONField(name="uid")
    protected String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
