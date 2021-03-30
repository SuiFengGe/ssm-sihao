package com.xhtx.service;

import com.xhtx.dao.UserMapper;
import com.xhtx.pojo.User;

public class UserServiceImpl implements UserService{

    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
