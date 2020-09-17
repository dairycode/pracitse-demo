package com.github.dairycode.mybatis.util;

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all")    // 抑制警告
public class IDUtils {

    // 获取随机id
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Test
    public void test() {
        System.out.println(IDUtils.getId());
    }
}
