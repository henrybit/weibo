package com.ffw.weibo.api.account;

import com.ffw.weibo.api.BaseAPI;
import com.ffw.weibo.entity.URLConstant;
import com.ffw.weibo.entity.request.GetEmailRequest;
import com.ffw.weibo.entity.request.GetUidRequest;
import com.ffw.weibo.entity.request.RateLimitStatusRequest;
import com.ffw.weibo.entity.response.BaseResponse;
import com.ffw.weibo.entity.response.GetEmailResponse;
import com.ffw.weibo.entity.response.GetUidResponse;
import com.ffw.weibo.entity.response.RateLimitStatusResponse;
import com.ffw.weibo.tools.JSONTools;
import com.ffw.weibo.tools.RequestTools;
import org.apache.http.NameValuePair;

import java.util.List;

/**
 * 账号相关API
 * Created by henrybit on 2017/3/17.
 * @version 1.0
 */
public class AccountAPI extends BaseAPI{

    /**
     * 获取API调用频次信息
     * @param request
     * @return RateLimitStatusResponse
     */
    public static RateLimitStatusResponse rateLimitStatus(RateLimitStatusRequest request) {
        if (request == null) return null;
        List<NameValuePair> pairList = RequestTools.getRequestParams(request);
        BaseResponse response = httpTools.post(URLConstant.API_ACCOUNT_RATE_LIMIT_STATUS, pairList);
        if (response != null) {
            RateLimitStatusResponse rateLimitStatusResponse = JSONTools.parserJson(response.getBody(), RateLimitStatusResponse.class);
            return rateLimitStatusResponse;
        }
        return null;
    }

    /**
     * 获取用户的联系邮箱
     * @param request
     * @return GetEmailResponse
     */
    public static GetEmailResponse getEmail(GetEmailRequest request) {
        if (request == null) return null;
        List<NameValuePair> pairList = RequestTools.getRequestParams(request);
        BaseResponse response = httpTools.post(URLConstant.API_ACCOUNT_PROFILE_EMAIL, pairList);
        if (response != null) {
            GetEmailResponse getEmailResponse = JSONTools.parserJson(response.getBody(), GetEmailResponse.class);
            return getEmailResponse;
        }
        return null;
    }

    /**
     * 获取用户的ID
     * @param request
     * @return GetUidResponse
     */
    public static GetUidResponse getUid(GetUidRequest request) {
        if (request == null) return null;
        List<NameValuePair> pairList = RequestTools.getRequestParams(request);
        BaseResponse response = httpTools.post(URLConstant.API_ACCOUNT_GET_UID, pairList);
        if (response != null) {
            GetUidResponse getUidResponse = JSONTools.parserJson(response.getBody(), GetUidResponse.class);
            return getUidResponse;
        }
        return null;
    }
}
