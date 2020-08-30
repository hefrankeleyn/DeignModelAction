package com.hef.domain;

import java.util.Map;

/**
 * @author lifei
 * @since 2020/8/30
 */
public class AuthToken {

    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime){
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval){
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    /**
     * 对字符串通过加密算法生成 Token
     * @param baseUrl
     * @param createTime
     * @param params
     * @return
     */
    public static AuthToken create(String baseUrl, long createTime, Map<String, String> params){
        return new AuthToken(baseUrl, createTime);
    }

    public String getToken(){
        return token;
    }

    /**
     * 根据时间判断字符串是否过期
     * @return
     *
     */
    public boolean isExpired(){
        return false;
    }

    /**
     * 验证两个token是否匹配
     * @param authToken
     * @return
     */
    public boolean match(AuthToken authToken){
        return false;
    }

}
