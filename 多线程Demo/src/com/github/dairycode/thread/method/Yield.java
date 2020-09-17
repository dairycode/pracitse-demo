package com.github.dairycode.thread.method;

// 测试礼让线程
// 礼让不一定成功,看CPU心情
public class Yield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield(); // 礼让
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }

    public static void main(String[] args) {
        Yield yield = new Yield();

        new Thread(yield, "a").start();
        new Thread(yield, "b").start();
    }
}
