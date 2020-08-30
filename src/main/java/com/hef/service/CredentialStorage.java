package com.hef.service;

/**
 * @author lifei
 * @since 2020/8/30
 */
public interface CredentialStorage {

    /**
     * 根据 appId 获取 密码
     * @param appId
     * @return
     */
    String getPasswordByAppId(String appId);

}
