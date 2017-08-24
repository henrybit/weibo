package com.ffw.weibo.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * API访问频率限制情况
 * {
 "ip_limit": 10000,
 "limit_time_unit": "HOURS",
 "remaining_ip_hits": 10000,
 "remaining_user_hits": 150,
 "reset_time": "2011-06-03 18:00:00",
 "reset_time_in_seconds": 1415,
 "user_limit": 150,
 }
 * Created by henrybit on 2017/3/17.
 * @version 1.0
 */
public class RateLimitStatusResponse extends BaseResponse{
    @JSONField(name="ip_limit")
    protected long ipLimit;
    @JSONField(name="limit_time_unit")
    protected String limitTimeUnit;
    @JSONField(name="remaining_ip_hits")
    protected long remainingIpHits;
    @JSONField(name="remaining_user_hits")
    protected long remainingUserHits;
    @JSONField(name="reset_time")
    protected String resetTime;
    @JSONField(name="reset_time_in_seconds")
    protected long resetTimeInSeconds;
    @JSONField(name="user_limit")
    protected long userLimit;

    public long getIpLimit() {
        return ipLimit;
    }

    public void setIpLimit(long ipLimit) {
        this.ipLimit = ipLimit;
    }

    public String getLimitTimeUnit() {
        return limitTimeUnit;
    }

    public void setLimitTimeUnit(String limitTimeUnit) {
        this.limitTimeUnit = limitTimeUnit;
    }

    public long getRemainingIpHits() {
        return remainingIpHits;
    }

    public void setRemainingIpHits(long remainingIpHits) {
        this.remainingIpHits = remainingIpHits;
    }

    public long getRemainingUserHits() {
        return remainingUserHits;
    }

    public void setRemainingUserHits(long remainingUserHits) {
        this.remainingUserHits = remainingUserHits;
    }

    public String getResetTime() {
        return resetTime;
    }

    public void setResetTime(String resetTime) {
        this.resetTime = resetTime;
    }

    public long getResetTimeInSeconds() {
        return resetTimeInSeconds;
    }

    public void setResetTimeInSeconds(long resetTimeInSeconds) {
        this.resetTimeInSeconds = resetTimeInSeconds;
    }

    public long getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(long userLimit) {
        this.userLimit = userLimit;
    }
}
