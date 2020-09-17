package com.github.dairycode.adapter;

// 客户端类: 想上网,插不上网线
public class Computer {

    // 电脑需要连接上转接器才可以上网
    public void net(NetToUsb adapter) {
        // 上网的具体实现,找一个转接头
        adapter.handleRequest();
    }

    public static void main(String[] args) {
        // 电脑,适配器,网线
        Computer computer = new Computer(); // 电脑
        Adaptee adaptee = new Adapter1();    // 网线
        Adapter1 adapter1 = new Adapter1();    // 适配器
        Adapter2 adapter2 = new Adapter2(adaptee);

        computer.net(adapter1);
        computer.net(adapter2);
    }
}
