package com.github.dairycode.thread.method;

// 测试线程的优先级
public class Priority implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        // 主线程默认优先级
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
        Priority priority = new Priority();

        Thread t1 = new Thread(priority);
        Thread t2 = new Thread(priority);
        Thread t3 = new Thread(priority);
        Thread t4 = new Thread(priority);
        Thread t5 = new Thread(priority);
        Thread t6 = new Thread(priority);

        // 先设置优先级,再启动
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);    // MAX_PRIORITY=10
        t4.start();

        // t5.setPriority(-1);
        // t5.start();

        // t6.setPriority(11);
        // t6.start();
    }
}
