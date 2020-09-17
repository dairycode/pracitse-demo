package com.github.dairycode.mybatis.dao;

import com.github.dairycode.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    // 根据ID查询用户
    User getUserById(int id);
}
