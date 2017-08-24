package com.ffw.weibo.api.oauth;

import com.ffw.weibo.api.BaseAPI;
import com.ffw.weibo.entity.URLConstant;
import com.ffw.weibo.entity.request.*;
import com.ffw.weibo.entity.response.*;
import com.ffw.weibo.tools.HttpTools;
import com.ffw.weibo.tools.JSONTools;
import com.ffw.weibo.tools.RequestTools;
import org.apache.http.NameValuePair;

import java.util.List;

/**
 * 授权相关API
 * Created by henrybit on 2017/3/17.
 * @version 1.0
 */
public class OauthAPI extends BaseAPI{

    /**
     * 1.获取申请AccessToken的Code
     * @param request
     * @return AuthorizeResponse
     */
    public static AuthorizeResponse createCode(AuthorizeRequest request) {
        if (request == null) return null;
        List<NameValuePair> pairList = RequestTools.getRequestParams(request);
        BaseResponse response = null;
        if ("mobile".equals(request.getDisplay())) {
            response = httpTools.post(URLConstant.API_MOBILE_OAUTH2_AUTHORIZE, pairList);
        } else {
            response = httpTools.post(URLConstant.API_OAUTH2_AUTHORIZE, pairList);
        }
        if (response != null) {
            AuthorizeResponse authResponse = JSONTools.parserJson(response.getBody(), AuthorizeResponse.class);
            return authResponse;
        }
        return null;
    }

    /**
     * 2.通过code获取AccessToken
     * @param request
     * @return AccessTokenResponse
     */
    public static AccessTokenResponse createAccesToken(AccessTokenRequest request) {
        if (request == null) return null;
        List<NameValuePair> pairList = RequestTools.getRequestParams(request);
        BaseResponse response = null;
        response = httpTools.post(URLConstant.API_OAUTH2_ACCESS_TOKEN, pairList);
        if (response != null) {
            AccessTokenResponse accessTokenResponse = JSONTools.parserJson(response.getBody(), AccessTokenResponse.class);
            return accessTokenResponse;
        }
        return null;
    }


    /**
     * 获取Token信息
     * @param request
     * @return GetTokenInfoResponse
     */
    public static GetTokenInfoResponse getTokenInfo(GetTokenInfoRequest request) {
        if (request == null) return null;
        List<NameValuePair> pairList = RequestTools.getRequestParams(request);
        BaseResponse response = null;
        response = httpTools.post(URLConstant.API_OAUTH2_GET_TOKEN_INFO, pairList);
        if (response != null) {
            GetTokenInfoResponse getTokenInfoResponse = JSONTools.parserJson(response.getBody(), GetTokenInfoResponse.class);
            return getTokenInfoResponse;
        }
        return null;
    }

    /**
     * 取消授权
     * @param request
     * @return
     */
    public static RevokeOauthResponse revokeOauth(RevokeOauthRequest request) {
        if (request == null) return null;
        List<NameValuePair> pairList = RequestTools.getRequestParams(request);
        BaseResponse response = null;
        response = httpTools.post(URLConstant.API_OAUTH2_REVOKEOAUTH2, pairList);
        if (response != null) {
            RevokeOauthResponse revokeOauthResponse = JSONTools.parserJson(response.getBody(), RevokeOauthResponse.class);
            return revokeOauthResponse;
        }
        return null;
    }

    /**
     * oauth1的accessToken转为oauth2的
     * @param request
     * @return Oauth1TOauth2Response
     */
    public static Oauth1TOauth2Response transformAccesToken2(Oauth1TOauth2Request request) {
        if (request == null) return null;
        List<NameValuePair> pairList = RequestTools.getRequestParams(request);
        BaseResponse response = null;
        response = httpTools.post(URLConstant.API_OAUTH2_GET_OAUTH2_TOKEN, pairList);
        if (response != null) {
            Oauth1TOauth2Response oauth1TOauth2Response = JSONTools.parserJson(response.getBody(), Oauth1TOauth2Response.class);
            return oauth1TOauth2Response;
        }
        return null;
    }
}
