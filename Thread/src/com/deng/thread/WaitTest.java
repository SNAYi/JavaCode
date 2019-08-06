package com.deng.thread;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-06 15:56
 * @Description:
 */
class MyThread1 implements Runnable{
    private boolean flag;
    private Object object;

    public MyThread1(boolean flag, Object object) {
        this.flag = flag;
        this.object = object;
    }

    @Override
    public void run() {
        if (flag) {
            waitMethod();
        } else {
            notifyMethod();
        }
    }
    public void waitMethod() {
        synchronized (object) {
            while (true) {
                System.out.println("wait方法开始" + Thread.currentThread().getName());
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait方法结束"+Thread.currentThread().getName());
                return;
            }
        }
    }
    public void notifyMethod() {
        synchronized (object) {
            while (true) {
                System.out.println("notify方法开始" + Thread.currentThread().getName());
                    object.notify();
                System.out.println("notify方法结束"+Thread.currentThread().getName());
                return;
            }
        }
    }
}
public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        MyThread1 waitThtread = new MyThread1(true,object);
        MyThread1 waitThtread2 = new MyThread1(true,object);
        MyThread1 notifyThread = new MyThread1(false,object);
        Thread thread1 = new Thread(waitThtread,"等待线程1");
        Thread thread12 = new Thread(waitThtread2,"等待线程2");
        Thread thread2 = new Thread(notifyThread,"唤醒线程");
        thread1.start();
        thread12.start();
//        Thread.sleep(1000);
        thread2.start();
    }
}
