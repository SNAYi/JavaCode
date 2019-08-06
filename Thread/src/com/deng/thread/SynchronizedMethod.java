package com.deng.thread;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-05 17:48
 * @Description:
 */
public class SynchronizedMethod implements Runnable{
    public static void main(String[] args) {
        SynchronizedMethod synchronizedMethod = new SynchronizedMethod();
        new Thread(synchronizedMethod,"黄牛1").start();
        new Thread(synchronizedMethod,"黄牛2").start();
        new Thread(synchronizedMethod,"黄牛3").start();
    }
    private int ticket = 100;
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            sale();
        }
        System.out.println("票卖完了，下次赶早");
    }
    private synchronized void sale(){
        if (ticket > 0) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"还有"+(ticket--)+"张票");
        }

    }
}
