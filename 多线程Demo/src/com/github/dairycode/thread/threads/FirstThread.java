package com.github.dairycode.thread.threads;

// 创建线程方式一: 继承Thread类,重写run()方法,调用start开启线程
// 总结: 线程开启不一定立即执行,由CPU调度执行
public class FirstThread extends Thread {
    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("我在写第一个多线程:" + i);
        }
    }

    public static void main(String[] args) {
        // main线程,主线程

        // 创建一个线程对象
        FirstThread firstThread = new FirstThread();

        // 调用start()方法开启线程
        firstThread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("我在学习多线程:" + i);
        }
    }
}
