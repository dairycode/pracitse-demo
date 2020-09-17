package com.github.dairycode.thread.threads;

// 创建线程方式二: 实现Runnable接口,重写run()方法,执行线程需要丢入Runnable接口实现类,调用start()方法
public class SecondThread implements Runnable {
    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("我在写第二个多线程:" + i);
        }
    }

    public static void main(String[] args) {
        // main线程,主线程

        // 创建Runnable接口的实现类对象
        SecondThread secondThread = new SecondThread();

        // 创建线程对象, 通过线程对象来开启我们的线程,代理
        // Thread thread = new Thread(secondThread);
        // thread.start();
        new Thread(secondThread).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("我在学习多线程:" + i);
        }
    }
}
