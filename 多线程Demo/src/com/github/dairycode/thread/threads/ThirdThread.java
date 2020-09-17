package com.github.dairycode.thread.threads;

import java.util.concurrent.*;

// 创建线程方式三: 实现Callable接口
/*
    Callable的好处:
    1.可以定义返回值
    2.可以抛出异常
 */
public class ThirdThread implements Callable {
    @Override
    public Boolean call() {
        // call方法线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("我在写第三个多线程:" + i);
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // main线程,主线程

        // 创建Runnable接口的实现类对象
        ThirdThread thirdThread = new ThirdThread();

        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(1);

        // 提交执行
        Future<Boolean> submit = ser.submit(thirdThread);

        for (int i = 0; i < 100; i++) {
            System.out.println("我在学习多线程:" + i);
        }

        // 获取结果
        boolean result = submit.get();

        // 关闭服务
        ser.shutdownNow();
    }
}
