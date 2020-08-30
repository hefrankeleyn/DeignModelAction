package com.hef.domain;

import java.util.Date;

/**
 * @author lifei
 * @since 2020/8/30
 */
public class ApiRequest {

    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    /**
     * 拼接
     * @param baseUrl
     * @param token
     * @param appId
     * @param timestamp
     */
    public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    /**
     * 解析
     * @param url
     * @return
     */
    public static ApiRequest createFromFullUrl(String url){
        return new ApiRequest("","","", new Date().getTime());
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
