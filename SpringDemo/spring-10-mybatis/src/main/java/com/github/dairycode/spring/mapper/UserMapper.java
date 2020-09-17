package com.github.dairycode.spring.mapper;

import com.github.dairycode.spring.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();
}
