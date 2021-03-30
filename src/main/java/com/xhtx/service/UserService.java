package com.xhtx.service;

import com.xhtx.pojo.User;

public interface UserService {
    //用户登录
    User getUser(User user);
    //用户注册
    int addUser(User user);
}
