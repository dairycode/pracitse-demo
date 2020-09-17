package com.github.dairycode.factory.simple;

// 静态工厂模式
// 增加一个新的产品,如果你不修改代码,做不到!

// 开闭原则
public class CarFactory {

    // 方法一:
    public static Car getCar(String car) {
        if ("五菱".equals(car)) {
            return new WuLing();
        } else if ("特斯拉".equals(car)) {
            return new Tesla();
        } else {
            return null;
        }
    }

    // 方法二:
    public static Car getWuLing() {
        return new WuLing();
    }
    public static Car getTesla() {
        return new Tesla();
    }
}
