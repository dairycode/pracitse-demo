package com.github.dairycode.factory.simple;

public class Customer {
    public static void main(String[] args) {
        // 使用工厂创建
        Car car1 = CarFactory.getCar("五菱");
        Car car2 = CarFactory.getCar("特斯拉");

        car1.name();
        car2.name();
    }
}
