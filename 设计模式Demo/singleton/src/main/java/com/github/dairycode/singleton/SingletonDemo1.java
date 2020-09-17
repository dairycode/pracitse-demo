package com.github.dairycode.singleton;

// 饿汉式单例
public class SingletonDemo1 {
    // 1.私有化构造器
    private SingletonDemo1() {}

    // 2.类初始化的时候,立即加载该对象
    private static SingletonDemo1 instance = new SingletonDemo1();

    // 3.提供获取该对象的方法,没有synchronized,效率高!
    public static SingletonDemo1 getInstance() {
        return instance;
    }
}

class SingletonDemo1Test {
    public static void main(String[] args) {
        SingletonDemo1 instance1 = SingletonDemo1.getInstance();
        SingletonDemo1 instance2 = SingletonDemo1.getInstance();

        System.out.println(instance1 == instance2);
    }
}
