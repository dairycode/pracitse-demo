package com.github.dairycode.adapter;

// 1.继承(类适配器,单继承)

// 真正的适配器,需要连接usb,连接网线
public class Adapter1 extends Adaptee implements NetToUsb {

    @Override
    public void handleRequest() {
        super.request();    // 可以上网了
    }
}
