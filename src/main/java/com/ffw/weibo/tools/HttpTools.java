package com.ffw.weibo.tools;

import com.ffw.weibo.entity.response.BaseResponse;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.util.*;
import java.util.zip.GZIPInputStream;

/**
 * HTTP请求工具
 * Created by henrybit on 15/12/22.
 * @version 1.0
 */
public class HttpTools {

    private HttpClient httpClient;
    private Map<String, String> header = new HashMap<String, String>();

    public HttpTools() {
        SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(9000).build();
        httpClient = HttpClientBuilder.create().setDefaultSocketConfig(socketConfig).build();
    }

    public HttpTools(int timeout) {
        SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(timeout).build();
        httpClient = HttpClientBuilder.create().setDefaultSocketConfig(socketConfig).build();
    }


    /**
     * 设置请求Header
     * @param name header name
     * @param value header value
     */
    public void setHeader(String name, String value) {
        if (!StringTools.isEmpty(name))
            header.put(name, value);
    }

    /**
     * 设置请求Header
     * @param _headers
     */
    public void setHeader(Map<String, String> _headers) {
        if (_headers != null) {
            header.putAll(_headers);
        }
    }

    /**
     * Post请求
     * @param url
     * @param postParam 请求参数通过&拼接(a=1&b=2)
     * @return BaseResponse 返回报文
     */
    public BaseResponse post(String url, String postParam){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        try {
            String[] array = postParam.split("&");
            for (int i=0; i<array.length; i++) {
                if (StringTools.isEmpty(array[i])) continue;
                String[] nameValue = array[i].split("\\=");
                String name = nameValue[0];
                String value = "";
                if (nameValue.length >= 2)
                    value = nameValue[1];
                NameValuePair nameValuePair = new BasicNameValuePair(name, value);
                params.add(nameValuePair);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post(url, params);
    }

    /**
     * 请求指定的URL
     * @param url
     * @param params 请求参数
     * @return BaseResponse 返回报文
     */
    public BaseResponse post(String url, List<NameValuePair> params) {
        BaseResponse baseResponse = new BaseResponse();
        HttpPost httpPost = new HttpPost(url);
        if (header.size() > 0) {
            Iterator<String> iterator = header.keySet().iterator();
            while(iterator.hasNext()) {
                String name = iterator.next();
                String value = header.get(name);
                httpPost.setHeader(name, value);
            }
        }
        try {
            if (params != null && params.size()>0)
                httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse httpResponse = null;
            httpResponse = httpClient.execute(httpPost);

            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                Header encodingHeader = httpEntity.getContentEncoding();
                String encoding = "";
                if (encodingHeader!=null)
                    encoding = encodingHeader.getValue();
                Header contentTypeHeader = httpEntity.getContentType();
                String charset = "";
                if (contentTypeHeader!=null && !StringTools.isEmpty(contentTypeHeader.getValue())) {
                    String contentType = contentTypeHeader.getValue();
                    int position = contentType.indexOf("charset");
                    if (position>=0)
                        charset = contentType.substring(position+8, contentType.length());
                }
                String body = getStringFromIS(encoding, httpEntity.getContent(), charset);
                baseResponse.setBody(body);
                StatusLine statusLine = httpResponse.getStatusLine();
                if (statusLine != null) {
                    int statusCode = statusLine.getStatusCode();
                    baseResponse.setHttpCode(statusCode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseResponse;
    }

    /**
     * Get请求接口
     * @param url
     * @return BaseResponse 返回报文
     */
    public BaseResponse get(String url) {
        BaseResponse baseResponse = new BaseResponse();
        HttpGet httpGet = new HttpGet(url);
        if (header.size() > 0) {
            Iterator<String> iterator = header.keySet().iterator();
            while(iterator.hasNext()) {
                String name = iterator.next();
                String value = header.get(name);
                httpGet.setHeader(name, value);
            }
        }
        try {
            HttpResponse httpResponse = null;
            httpResponse = httpClient.execute(httpGet);
            Header[] headers = httpResponse.getHeaders("Set-Cookie");
            if (headers == null){
                headers = httpResponse.getHeaders("set-cookie");
            }
            StringBuilder cookie = new StringBuilder();
            for (int i=0; headers!=null&&i<headers.length; i++) {
                if (headers[i] == null) continue;
                cookie.append(headers[i].getValue());
            }
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                Header encodingHeader = httpEntity.getContentEncoding();
                String encoding = "";
                if (encodingHeader!=null)
                    encoding = encodingHeader.getValue();
                Header contentTypeHeader = httpEntity.getContentType();
                String charset = "";
                if (contentTypeHeader!=null && !StringTools.isEmpty(contentTypeHeader.getValue())) {
                    String contentType = contentTypeHeader.getValue();
                    int position = contentType.indexOf("charset");
                    if (position>=0)
                        charset = contentType.substring(position+8, contentType.length());
                }
                String body = getStringFromIS(encoding, httpEntity.getContent(), charset);
                baseResponse.setBody(body);
                StatusLine statusLine = httpResponse.getStatusLine();
                if (statusLine != null) {
                    int statusCode = statusLine.getStatusCode();
                    baseResponse.setHttpCode(statusCode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return baseResponse;
    }

    /**
     * 读取流中的内容(UTF8)
     * @param contentEncoding 是否http压缩
     * @param is 流
     * @return String
     */
    private String getStringFromIS(String contentEncoding, InputStream is) {
        return getStringFromIS(contentEncoding, is, "utf-8");
    }

    /**
     * 读取流中的内容
     * @param contentEncoding 是否压缩
     * @param is 流
     * @param charSet 编码方式
     * @return String
     */
    private String getStringFromIS(String contentEncoding, InputStream is, String charSet) {
        if (contentEncoding!=null && contentEncoding.indexOf("gzip")>-1) {
            //For GZip response
            try {
                if (StringTools.isEmpty(charSet)) charSet = "utf-8";
                GZIPInputStream gzin = new GZIPInputStream(is);

                InputStreamReader isr = new InputStreamReader(gzin, charSet);
                BufferedReader br = new BufferedReader(isr);
                StringBuffer sb = new StringBuffer();
                String tempbf;
                while ((tempbf = br.readLine()) != null) {
                    sb.append(tempbf);
                    sb.append("\r\n");
                }
                isr.close();
                gzin.close();
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();

            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception{
    }
}
