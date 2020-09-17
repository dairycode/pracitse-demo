package com.github.dairycode.singleton;

public enum SingletonDemo5 {
    INSTANCE;

    public SingletonDemo5 getInstance() {
        return INSTANCE;
    }
}

class SingletonDemo5Test {
    public static void main(String[] args) {
        SingletonDemo5 instance1 = SingletonDemo5.INSTANCE;
        SingletonDemo5 instance2 = SingletonDemo5.INSTANCE;
        System.out.println(instance1 == instance2);
    }
}
