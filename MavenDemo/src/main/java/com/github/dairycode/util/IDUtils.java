package com.github.dairycode.util;

import java.util.UUID;

public class IDUtils {
    // 获取随机ID
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
