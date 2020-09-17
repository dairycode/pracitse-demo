package com.github.dairycode.mybatis.dao;

import com.github.dairycode.mybatis.pojo.User;
import com.github.dairycode.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void queryUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user1 = mapper.queryUserById(1);
        System.out.println(user1);

        // mapper.updateUser(new User(2, "aaa", "bbb"));
        sqlSession.clearCache();

        System.out.println("===============================");
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user1==user2);

        sqlSession.close();
    }

    @Test
    public void testCache() {
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user1 = mapper1.queryUserById(1);
        System.out.println(user1);
        sqlSession1.close();

        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println(user1==user2);
    }
}
