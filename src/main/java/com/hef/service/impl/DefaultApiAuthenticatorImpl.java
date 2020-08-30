package com.hef.service.impl;

import com.hef.domain.ApiRequest;
import com.hef.domain.AuthToken;
import com.hef.service.ApiAuthenticator;
import com.hef.service.CredentialStorage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lifei
 * @since 2020/8/30
 */
public class DefaultApiAuthenticatorImpl implements ApiAuthenticator {

    private CredentialStorage credentialStorage;

    public DefaultApiAuthenticatorImpl() {
        this.credentialStorage = new CredentialStorageImpl();
    }

    public DefaultApiAuthenticatorImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);

    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String baseUrl = apiRequest.getBaseUrl();
        long timestamp = apiRequest.getTimestamp();
        String token = apiRequest.getToken();
        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if(clientAuthToken.isExpired()){
            throw new RuntimeException("Token is expired");
        }

        String password = credentialStorage.getPasswordByAppId(appId);
        Map<String, String> params  = new HashMap<>();
        params.put("password", password);
        params.put("appId", appId);
        AuthToken serverAuthToken = AuthToken.create(baseUrl, timestamp, params);
        if (!serverAuthToken.match(clientAuthToken)){
            throw new RuntimeException("Token verfication failed.");
        }

    }
}
