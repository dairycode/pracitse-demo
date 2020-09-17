package com.github.dairycode.mybatis.dao;

import com.github.dairycode.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    // 根据ID查询用户
    User queryUserById(@Param("id") int id);

    int updateUser(User user);
}
