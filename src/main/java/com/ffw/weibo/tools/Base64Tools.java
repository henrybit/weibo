package com.ffw.weibo.tools;

import org.apache.commons.codec.binary.Base64;


/**
 * Created by henrybit on 15/12/14.
 */
public class Base64Tools {

    /**
     * 编码HttpUtil.java
     * @param ori
     * @return string
     */
    public static String encode(String ori) {
        if (StringTools.isEmpty(ori)) return ori;
        try {
            byte[] encodeBytes = Base64.encodeBase64(ori.getBytes("utf-8"));
            return new String(encodeBytes,"utf-8");
        } catch (Exception e){
        }
        return ori;
    }

    /**
     * URL-Safe的编码方式
     * @param ori
     * @return
     */
    public static String encodeUrlSafe(String ori) {
        if (StringTools.isEmpty(ori)) return ori;
        try {
            byte[] encodeBytes = Base64.encodeBase64URLSafe(ori.getBytes("utf-8"));
            return new String(encodeBytes,"utf-8");
        } catch (Exception e){
        }
        return ori;
    }

    /**
     * 解码
     * @param encodeString
     * @return string
     */
    public static String decode(String encodeString) {
        if (StringTools.isEmpty(encodeString)) return encodeString;
        try {
            byte[] oriBytes = Base64.decodeBase64(encodeString.getBytes("utf-8"));
            return new String(oriBytes,"utf-8");
        } catch (Exception e) {
        }
        return encodeString;
    }

    /**
     * URL-Safe的解码方式
     * @param encodeString
     * @return string
     */
    public static String decodeUrlSafe(String encodeString) {
        if (StringTools.isEmpty(encodeString)) return encodeString;
        try {
            byte[] oriBytes = Base64.decodeBase64(encodeString.getBytes("utf-8"));
            return new String(oriBytes,"utf-8");
        } catch (Exception e) {
        }
        return encodeString;
    }

    public static void main(String[] args) throws Exception {
        String str = "eyJwb2lpZCI6Ijc2MzgwNjMiLCJ0eXBlIjoicG9pIiwibmFtZSI6Iuael-mbquW5s-aZr-eCuSIsImRlc2MiOiIiLCJhZGRyZXNzIjoiIiwiZ2VvIjp7ImxhdCI6IjU4LjQwMjEzOCIsImxuZyI6IjE1LjU0Mjg1In0sImltYWdlcyI6W10sInRlbCI6IiIsIndlYnNpdGUiOiIiLCJ0YWZmaWMiOiIiLCJ0aWNrZXQiOiIiLCJvcGVuaW5nIjoiIiwiZ29uZ2x2IjoiIiwiY29tbWVudGNvdW50IjoiIiwiY29tbWVudHMiOltdLCJ1cmwiOiJhSFIwY0RvdkwzZDNkeTV0WVdabGJtZDNieTVqYmk5d2Iya3ZOell6T0RBMk15NW9kRzFzIn0";
        System.out.println(decodeUrlSafe(str));
    }
}
