package com.github.dairycode.builder.demo2;

// 建造者
public abstract class Builder {

    abstract public Builder builderA(String msg); // 汉堡
    abstract public Builder builderB(String msg); // 可乐
    abstract public Builder builderC(String msg); // 薯条
    abstract public Builder builderD(String msg); // 甜点

    abstract Product getProduct();
}
