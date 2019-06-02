package com.deng.thread;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/21 下午 08:49
 */

class NameThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程为："+Thread.currentThread().getName()+
                    ",i="+i);
        }
    }
}
public class ThreadName {
    public static void main(String[] args) {
        Runnable run =new NameThread();
        Thread thread1 = new Thread(run,"线程A");
        Thread thread2 = new Thread(run);
        thread2.setName("线程B");
        thread1.start();
        thread2.start();
    }
}
