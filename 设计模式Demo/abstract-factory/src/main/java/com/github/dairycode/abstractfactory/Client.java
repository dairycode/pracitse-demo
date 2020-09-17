package com.github.dairycode.abstractfactory;

public class Client {
    public static void main(String[] args) {

        System.out.println("========小米系列产品========");
        // 小米工厂
        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        PhoneProduct phoneProduct = xiaomiFactory.phoneProduct();
        phoneProduct.callup();
        phoneProduct.sendSMS();

        RouterProduct routerProduct = xiaomiFactory.routerProduct();
        routerProduct.openwifi();

        System.out.println("========华为系列产品========");
        // 小米工厂
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        phoneProduct = huaweiFactory.phoneProduct();
        phoneProduct.callup();
        phoneProduct.sendSMS();

        routerProduct = huaweiFactory.routerProduct();
        routerProduct.openwifi();
    }
}
