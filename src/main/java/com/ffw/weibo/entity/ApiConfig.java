package com.ffw.weibo.entity;

/**
 * 微博的关键配置信息
 * Created by henrybit on 2017/3/10.
 * @version 1.0
 */
public class ApiConfig {
    //微博App Key
    protected String appKey;
    //微博App Secret
    protected String appSecret;

    public ApiConfig(String appKey, String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
    }
}
