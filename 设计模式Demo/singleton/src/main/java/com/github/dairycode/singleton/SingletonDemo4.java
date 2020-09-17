package com.github.dairycode.singleton;

public class SingletonDemo4 {
    private SingletonDemo4() {}

    private static class InnerClass {
        private static final SingletonDemo4 instance = new SingletonDemo4();
    }

    public static SingletonDemo4 getInstance() {
        return InnerClass.instance;
    }
}

// 反射机制: 可以破坏我们以上的单例
class SingletonDemo4Test {
    public static void main(String[] args) {
        SingletonDemo4 instance1 = SingletonDemo4.getInstance();
        SingletonDemo4 instance2 = SingletonDemo4.getInstance();

        System.out.println(instance1 == instance2);
    }
}
