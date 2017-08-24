package com.ffw.weibo.entity.request;

import com.ffw.weibo.tools.RequestField;

/**
 <table border="1" cellspacing="0" cellpadding="0" width="100%" class="parameters" style="border-color: #CCCCCC;">

 <tbody><tr>
 <th width="10%" style="text-align:center;font-weight:bolder;border:1px solid #cccccc">&nbsp;
 </th>
 <th width="5%" style="text-align:center;font-weight:bolder;border:1px solid #cccccc">必选
 </th>
 <th width="10%" style="text-align:center;font-weight:bolder;border:1px solid #cccccc">类型及范围
 </th>
 <th width="75%" style="text-align:center;font-weight:bolder;border:1px solid #cccccc">说明
 </th></tr>
 <tr>
 <td style="text-align:center;font-weight:bolder;border:1px solid #cccccc">client_id
 </td>
 <td style="text-align:center;text-transform:lowercase;border:1px solid #cccccc">true
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">string
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">申请应用时分配的AppKey。
 </td></tr>
 <tr>
 <td style="text-align:center;font-weight:bolder;border:1px solid #cccccc">redirect_uri
 </td>
 <td style="text-align:center;text-transform:lowercase;border:1px solid #cccccc">true
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">string
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">授权回调地址，站外应用需与设置的回调地址一致，站内应用需填写canvas page的地址。
 </td></tr>
 <tr>
 <td style="text-align:center;font-weight:bolder;border:1px solid #cccccc">scope
 </td>
 <td style="text-align:center;text-transform:lowercase;border:1px solid #cccccc">false
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">string
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">申请scope权限所需参数，可一次申请多个scope权限，用逗号分隔。<a href="/wiki/Scope" title="Scope">使用文档</a>
 </td></tr>
 <tr>
 <td style="text-align:center;font-weight:bolder;border:1px solid #cccccc">state
 </td>
 <td style="text-align:center;text-transform:lowercase;border:1px solid #cccccc">false
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">string
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">用于保持请求和回调的状态，在回调时，会在Query Parameter中回传该参数。开发者可以用这个参数验证请求有效性，也可以记录用户请求授权页前的位置。这个参数可用于防止跨站请求伪造（CSRF）攻击
 </td></tr>
 <tr>
 <td style="text-align:center;font-weight:bolder;border:1px solid #cccccc">display
 </td>
 <td style="text-align:center;text-transform:lowercase;border:1px solid #cccccc">false
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">string
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">授权页面的终端类型，取值见下面的说明。
 </td></tr>
 <tr>
 <td style="text-align:center;font-weight:bolder;border:1px solid #cccccc">forcelogin
 </td>
 <td style="text-align:center;text-transform:lowercase;border:1px solid #cccccc">false
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">boolean
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">是否强制用户重新登录，true：是，false：否。默认false。
 </td></tr>
 <tr>
 <td style="text-align:center;font-weight:bolder;border:1px solid #cccccc">language
 </td>
 <td style="text-align:center;text-transform:lowercase;border:1px solid #cccccc">false
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">string
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">授权页语言，缺省为中文简体版，en为英文版。英文版测试中，开发者任何意见可反馈至 @微博API
 </td></tr></tbody></table>

 <dl><dt><b>display说明：</b></dt></dl>
 <table border="1" cellspacing="0" cellpadding="0" width="100%" class="parameters" style="border-color: #CCCCCC;">
 <tbody><tr>
 <th width="20%" style="text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc">参数取值
 </th>
 <th width="80%" style="text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc">类型说明
 </th></tr>
 <tr>
 <td style="text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc">default
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">默认的授权页面，适用于web浏览器。
 </td></tr>
 <tr>
 <td style="text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc">mobile
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">移动终端的授权页面，适用于支持html5的手机。注：使用此版授权页请用 <a rel="nofollow" class="external free" href="https://open.weibo.cn/oauth2/authorize">https://open.weibo.cn/oauth2/authorize</a> 授权接口
 </td></tr>
 <tr>
 <td style="text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc">wap
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">wap版授权页面，适用于非智能手机。
 </td></tr>
 <tr>
 <td style="text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc">client
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">客户端版本授权页面，适用于PC桌面应用。
 </td></tr>
 <tr>
 <td style="text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc">apponweibo
 </td>
 <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">默认的站内应用授权页，授权后不返回access_token，只刷新站内应用父框架。
 </td></tr></tbody></table>
 * Created by henrybit on 2017/3/10.
 * @version 1.0
 */
public class AuthorizeRequest extends BaseRequest{
    @RequestField(name="client_id", require=true)
    private String clientId;
    @RequestField(name="redirect_uri", require=true)
    private String redirectUri;
    @RequestField(name="scope")
    private String scope;
    @RequestField(name="state")
    private String state;
    @RequestField(name="display")
    private String display;
    @RequestField(name="forcelogin")
    private boolean forcelogin;
    @RequestField(name="language")
    private String language;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public boolean isForcelogin() {
        return forcelogin;
    }

    public void setForcelogin(boolean forcelogin) {
        this.forcelogin = forcelogin;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
