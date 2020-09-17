package com.github.dairycode.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 本身就是Spring的一个组件

// 程序的主入口
@SpringBootApplication  // 标注这个类是一个SpringBoot的应用,启动类下所有资源被导入
public class SpringbootApplication {

    // SpringApplication
    public static void main(String[] args) {
        // 将SpringBoot应用启动
        // SpringApplication类
        // run方法
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
