package com.deng.thread;/**
 *
 */

import java.util.concurrent.Callable;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/21 下午 07:29
 */


//2.继承Thread来实现多线程
class MyThread2 extends Thread {
    private int ticket = 20;
    private String title;

    public MyThread2(String title) {
        this.title = title;
    }

    public void run() {
        while (ticket > 0) {
            System.out.println("当前线程为"+title+"剩余票数为"+ticket--);
        }
    }
}
public class TestThread {
    //1.实现Runnable来实现多线程

    //2.继承Thread来实现多线程
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2("myThread2");    //1.创建真实线程类
        MyThread2 myThread22 = new MyThread2("myThread2");    //1.创建真实线程类
        MyThread2 myThread23 = new MyThread2("myThread23");    //1.创建真实线程类

        //Thread类提供的构造可接收Runnable的对象
        Thread thread1 = new Thread(myThread2);    //2.三个代理线程类共享一个线程 20张票
        Thread thread2 = new Thread(myThread22);
        Thread thread3 = new Thread(myThread23);
        thread1.start();    //3.启动线程
        thread2.start();
        thread3.start();
    }
}
