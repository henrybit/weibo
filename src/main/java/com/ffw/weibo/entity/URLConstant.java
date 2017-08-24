package com.ffw.weibo.entity;

/**
 * URL接口常量地址
 * Created by henrybit on 2017/3/9.
 * @version 1.0
 */
public class URLConstant {

    /**oauth2 api start*/
    //请求授权-请求用户授权Token的Code
    public final static String API_OAUTH2_AUTHORIZE = "https://api.weibo.com/oauth2/authorize";
    //请求授权-请求用户授权Token的Code-适用于mobile
    public final static String API_MOBILE_OAUTH2_AUTHORIZE = "https://open.weibo.cn/oauth2/authorize";
    //获取授权-获取授权过的Access Token
    public final static String API_OAUTH2_ACCESS_TOKEN = "https://api.weibo.com/oauth2/access_token";
    //授权查询-查询用户access_token的授权相关信息
    public final static String API_OAUTH2_GET_TOKEN_INFO = "https://api.weibo.com/oauth2/get_token_info";
    //替换授权-OAuth1.0的Access Token更换至OAuth2.0的Access Token
    public final static String API_OAUTH2_GET_OAUTH2_TOKEN = "https://api.weibo.com/oauth2/get_oauth2_token";
    //授权回收-授权回收接口，帮助开发者主动取消用户的授权
    public final static String API_OAUTH2_REVOKEOAUTH2 = "https://api.weibo.com/oauth2/revokeoauth2";
    /**oauth2 api end*/

    /**account api start*/
    //获取当前用户API访问频率限制
    public final static String API_ACCOUNT_RATE_LIMIT_STATUS = "https://api.weibo.com/2/account/rate_limit_status.json";
    //获取用户的联系邮箱
    public final static String API_ACCOUNT_PROFILE_EMAIL = "https://api.weibo.com/2/account/profile/email.json";
    //OAuth授权之后获取用户UID
    public final static String API_ACCOUNT_GET_UID = "https://api.weibo.com/2/account/get_uid.json";
    /**account api end*/

    /**公共模块 start*/
    //通过地址编码获取地址名称
    public final static String API_CODE_TO_LOCATION = "https://api.weibo.com/2/common/code_to_location.json";
    //获取城市列表
    public final static String API_GET_CITY = "https://api.weibo.com/2/common/get_city.json";
    //获取省份列表
    public final static String API_GET_PROVINCE = "https://api.weibo.com/2/common/get_province.json";
    //获取国家列表
    public final static String API_GET_COUNTRY = "https://api.weibo.com/2/common/get_country.json";
    //获取时区列表
    public final static String API_GET_TIMEZONE = "https://api.weibo.com/2/common/get_timezone.json";
    /**公共模块 end*/

    /**超链接模块 start*/
    //将一个或多个长链接转换成短链接
    public final static String API_SHORTEN = "https://api.weibo.com/2/short_url/shorten.json";
    /**超链接模块 end*/
}
