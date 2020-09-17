package com.github.dairycode.thread.method;

// 测试join方法,想象为插队
public class Join implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 启动我们的线程
        Join join = new Join();
        Thread thread = new Thread(join);
        thread.start();

        // 主线程
        for (int i = 0; i < 1000; i++) {
            if (i == 200) {
                thread.join();  // 插队
            }
            System.out.println("main:" + i);
        }
    }
}
