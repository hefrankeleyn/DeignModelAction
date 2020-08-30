package com.hef.service;

import com.hef.domain.ApiRequest;

public interface ApiAuthenticator {

    void auth(String url);

    void auth(ApiRequest apiRequest);
}
