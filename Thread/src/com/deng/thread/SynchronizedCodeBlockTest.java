package com.deng.thread;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-01 23:09
 * @Description:
 */
public class SynchronizedCodeBlockTest implements Runnable{
    private Integer ticket = 1000;
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
        //同步代码块
        synchronized (this) {
            if (ticket > 0) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                System.out.println(Thread.currentThread().getName()+"还有"+ticket--+"张票");
                }
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedCodeBlockTest test = new SynchronizedCodeBlockTest();
        Thread thread = new Thread(test,"买家1");
        Thread thread2 = new Thread(test,"买家2");
        Thread thread3 = new Thread(test,"买家3");
        thread.start();
        thread2.start();
        thread3.start();
    }
}
