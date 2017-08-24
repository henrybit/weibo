package com.ffw.weibo.entity.request;

import com.ffw.weibo.tools.RequestField;

/**
 * accessToken-oauth1转oauth2
 * Created by henrybit on 2017/3/17.
 * @version 1.0
 */
public class Oauth1TOauth2Request extends BaseRequest{
    @RequestField(name="oauth_consumer_key")
    protected String oauthConsumerKey;
    @RequestField(name="oauth_token")
    protected String oauthToken;
    @RequestField(name="oauth_signature_method")
    protected String oauthSignatureMethod;
    @RequestField(name="oauth_timestamp")
    protected String oauthTimestamp;
    @RequestField(name="oauth_nonce")
    protected String oauthNonce;
    @RequestField(name="oauth_version")
    protected String oauthVersion;
    @RequestField(name="oauth_signature")
    protected String oauthSignature;

    public String getOauthConsumerKey() {
        return oauthConsumerKey;
    }

    public void setOauthConsumerKey(String oauthConsumerKey) {
        this.oauthConsumerKey = oauthConsumerKey;
    }

    public String getOauthToken() {
        return oauthToken;
    }

    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }

    public String getOauthSignatureMethod() {
        return oauthSignatureMethod;
    }

    public void setOauthSignatureMethod(String oauthSignatureMethod) {
        this.oauthSignatureMethod = oauthSignatureMethod;
    }

    public String getOauthTimestamp() {
        return oauthTimestamp;
    }

    public void setOauthTimestamp(String oauthTimestamp) {
        this.oauthTimestamp = oauthTimestamp;
    }

    public String getOauthNonce() {
        return oauthNonce;
    }

    public void setOauthNonce(String oauthNonce) {
        this.oauthNonce = oauthNonce;
    }

    public String getOauthVersion() {
        return oauthVersion;
    }

    public void setOauthVersion(String oauthVersion) {
        this.oauthVersion = oauthVersion;
    }

    public String getOauthSignature() {
        return oauthSignature;
    }

    public void setOauthSignature(String oauthSignature) {
        this.oauthSignature = oauthSignature;
    }
}
