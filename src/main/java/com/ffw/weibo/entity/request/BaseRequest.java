package com.ffw.weibo.entity.request;

import com.ffw.weibo.tools.JSONTools;

/**
 * 基本请求参数
 * Created by henrybit on 2017/3/10.
 * @version 1.0
 */
public class BaseRequest {

    @Override
    public String toString() {
        return JSONTools.toJson(this);
    }

}
