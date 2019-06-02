package com.deng.thread;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/21 下午 07:51
 */

//1.实现Runnable来实现多线程
class MyThread implements Runnable {
    private int ticket = 20;

    public void run() {
        while (ticket > 0) {
            System.out.println("当前线程为"+Thread.currentThread().getName()+"剩余票数为"+ticket--);
        }
    }
}

public class TestRunnable {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();    //1.创建真实线程类
        Thread thread1 = new Thread(myThread,"买票人A");    //2.三个代理线程类共享一个线程 20张票
        Thread thread2 = new Thread(myThread,"买票人B");
        Thread thread3 = new Thread(myThread,"买票人C");
        thread1.start();    //3.启动线程
        thread2.start();
        thread3.start();
    }
}

