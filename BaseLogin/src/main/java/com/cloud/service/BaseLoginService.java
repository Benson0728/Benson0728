package com.cloud.service;

import org.cloud.pojo.User;

public interface BaseLoginService {
    User select(String username);
}
