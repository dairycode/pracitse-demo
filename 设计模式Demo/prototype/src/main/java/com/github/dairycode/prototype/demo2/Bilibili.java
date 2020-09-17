package com.github.dairycode.prototype.demo2;

import java.util.Date;

/*
    客户端: 克隆
    此处为深克隆!
 */
public class Bilibili {

    public static void main(String[] args) throws CloneNotSupportedException {
        // 原型对象 v1
        Date date = new Date();
        Video v1 = new Video("dairycode", date);
        System.out.println("v1=>" + v1);
        System.out.println("v1=>hash:" + v1.hashCode());

        // v1 克隆 v2
        Video v2 = (Video) v1.clone();  // 克隆出来的对象和原来是一模一样的
        System.out.println("v2=>" + v2);
        System.out.println("v2=>hash:" + v2.hashCode());

        v2.setName("Clone: dairycode");
        System.out.println(v1);
        System.out.println(v2);
    }
}
