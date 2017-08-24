package com.ffw.weibo.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * AccessToken的返回报文<br>
 返回值字段	字段类型	字段说明
 access_token	string	用户授权的唯一票据，用于调用微博的开放接口，同时也是第三方应用验证微博用户登录的唯一票据，第三方应用应该用该票据和自己应用内的用户建立唯一影射关系，来识别登录状态，不能使用本返回值里的UID字段来做登录识别。
 expires_in	string	access_token的生命周期，单位是秒数。
 remind_in	string	access_token的生命周期（该参数即将废弃，开发者请使用expires_in）。
 uid	string	授权用户的UID，本字段只是为了方便开发者，减少一次user/show接口调用而返回的，第三方应用不能用此字段作为用户登录状态的识别，只有access_token才是用户授权的唯一票据。

 返回数据：
 {
 "access_token": "ACCESS_TOKEN",
 "expires_in": 1234,
 "remind_in":"798114",
 "uid":"12341234"
 }
 * Created by henrybit on 2017/3/17.
 * @version 1.0
 */
public class AccessTokenResponse extends BaseResponse{
    @JSONField(name="access_token")
    protected String accessToken;
    @JSONField(name="expires_in")
    protected long expiresIn;
    @JSONField(name="remind_in")
    protected long remindIn;
    @JSONField(name="uid")
    protected String uid;

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

    public long getRemindIn() {
        return remindIn;
    }

    public void setRemindIn(long remindIn) {
        this.remindIn = remindIn;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
