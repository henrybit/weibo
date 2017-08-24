package com.ffw.weibo.api.shorturl;

import com.ffw.weibo.api.BaseAPI;
import com.ffw.weibo.entity.URLConstant;
import com.ffw.weibo.entity.request.LongUrlToShortRequest;
import com.ffw.weibo.entity.response.BaseResponse;
import com.ffw.weibo.entity.response.LongUrlToShortResponse;
import com.ffw.weibo.tools.JSONTools;
import com.ffw.weibo.tools.RequestTools;
import org.apache.http.NameValuePair;

import java.util.HashMap;
import java.util.List;

/**
 * 短连接API
 * Created by henrybit on 2017/3/18.
 * @version 1.0
 */
public class ShortUrlAPI extends BaseAPI{
    /**
     * 长连接转短连接
     * @param request
     * @return
     */
    public static LongUrlToShortResponse longUrlToShort(LongUrlToShortRequest request) {
        if (request == null) return null;
        List<NameValuePair> pairList = RequestTools.getRequestParams(request);
        BaseResponse response = httpTools.post(URLConstant.API_SHORTEN, pairList);
        if (response != null) {
            LongUrlToShortResponse longUrlToShortResponse = JSONTools.parserJson(response.getBody(), LongUrlToShortResponse.class);
            return longUrlToShortResponse;
        }
        return null;
    }
}
