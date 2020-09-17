package com.github.dairycode.spring.service;

import com.github.dairycode.spring.dao.UserDao;

public interface UserService {
    void getUser();
    void setUserDao(UserDao userDao);
}
