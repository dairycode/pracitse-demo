package com.github.dairycode.adapter;

// 2.组合(对象适配器:常用)

// 真正的适配器,需要连接usb,连接网线
public class Adapter2 implements NetToUsb {

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        adaptee.request();  // 可以上网了
    }
}
