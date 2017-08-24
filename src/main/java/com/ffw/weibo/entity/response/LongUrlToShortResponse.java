package com.ffw.weibo.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 返回值字段	字段类型	字段说明
 url_short	string	短链接
 url_long	string	原始长链接
 type	int	链接的类型，0：普通网页、1：视频、2：音乐、3：活动、5、投票
 result	boolean	短链的可用状态，true：可用、false：不可用。

 {
 "urls": [
 {
 "url_short": "http://t.cn/h4DwT1",
 "url_long": "http://finance.sina.com.cn/",
 "type": 0,
 "result": "true"
 },
 {
 "url_short": "",
 "url_long": "http://finance.sina.com.cn/",
 "type": 0,
 "result": "false"
 },
 ...
 ]
 }
 * Created by henrybit on 2017/3/18.
 * @version 1.0
 */
public class LongUrlToShortResponse extends BaseResponse{
    @JSONField(name="urls")
    protected List<ShortUrl> urls;

    public List<ShortUrl> getUrls() {
        return urls;
    }

    public void setUrls(List<ShortUrl> urls) {
        this.urls = urls;
    }

    class ShortUrl {
        @JSONField(name="url_short")
        protected String urlShort;
        @JSONField(name="url_long")
        protected String urlLong;
        @JSONField(name="type")
        protected int type;
        @JSONField(name="result")
        protected String result;

        public String getUrlShort() {
            return urlShort;
        }

        public void setUrlShort(String urlShort) {
            this.urlShort = urlShort;
        }

        public String getUrlLong() {
            return urlLong;
        }

        public void setUrlLong(String urlLong) {
            this.urlLong = urlLong;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
