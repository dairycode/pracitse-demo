package com.github.dairycode.singleton;

// DCL懒汉式单例
public class SingletonDemo3 {
    // 1.私有化构造器
    private SingletonDemo3() {}

    // 2.类初始化的时候,不立即加载该对象
    private volatile static SingletonDemo3 instance;

    // 3.提供获取该对象的方法,有synchronized,效率较低!
    public static SingletonDemo3 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo3.class) {
                if (instance == null) {
                    instance = new SingletonDemo3();
                }
            }
        }
        return instance;
    }
}

class SingletonDemo3Test {
    public static void main(String[] args) {
        SingletonDemo3 instance1 = SingletonDemo3.getInstance();
        SingletonDemo3 instance2 = SingletonDemo3.getInstance();

        System.out.println(instance1 == instance2);
    }
}
