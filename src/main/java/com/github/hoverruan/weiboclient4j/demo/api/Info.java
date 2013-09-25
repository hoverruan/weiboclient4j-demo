package com.github.hoverruan.weiboclient4j.demo.api;

import weiboclient4j.model.User;

public class Info {
    private final String accessToken;

    private final User user;

    public Info(String accessToken, User user) {
        this.accessToken = accessToken;
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public User getUser() {
        return user;
    }
}
