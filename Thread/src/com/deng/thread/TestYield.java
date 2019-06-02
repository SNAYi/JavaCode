package com.deng.thread;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/28 下午 06:17
 */

class IThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            //Thread.yield();
            System.out.println("当前线程为" + Thread.currentThread().getName()+",i="+i);
        }
    }
}

public class TestYield {
    public static void main(String[] args) {
        IThread iThread = new IThread();
        Thread thread1 = new Thread(iThread);
        Thread thread2 = new Thread(iThread);
        Thread thread3 = new Thread(iThread);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}



