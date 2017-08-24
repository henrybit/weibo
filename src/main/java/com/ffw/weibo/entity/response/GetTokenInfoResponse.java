package com.ffw.weibo.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户授权信息
 返回值字段	字段类型	字段说明
 uid	string	授权用户的uid。
 appkey	string	access_token所属的应用appkey。
 scope	string	用户授权的scope权限。
 create_at	string	access_token的创建时间，从1970年到创建时间的秒数。
 expire_in	string	access_token的剩余时间，单位是秒数。
 * Created by henrybit on 2017/3/17.
 * @version 1.0
 */
public class GetTokenInfoResponse extends BaseResponse{
    @JSONField(name="uid")
    protected String uid;
    @JSONField(name="appkey")
    protected String appkey;
    @JSONField(name="scope")
    protected String scope;
    @JSONField(name="create_at")
    protected long createAt;
    @JSONField(name="expire_in")
    protected long expireIn;

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(long expireIn) {
        this.expireIn = expireIn;
    }
}
