package com.deng.thread;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/24 下午 09:02
 */


public class SellTicket implements Runnable{
    private int ticket = 20000;
    @Override
    public void run() {
        for(int i = 0; i < 20000; i++) {
            synchronized (this) {
                if (ticket >0){
                    System.out.println("当前线程为" + Thread.currentThread().getName() + "剩余票数为" + ticket--);
                }
            }

        }
    }
    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();    //1.创建真实线程类
        Thread thread1 = new Thread(sellTicket, "买票人A");    //2.三个代理线程类共享一个线程 20张票
        Thread thread2 = new Thread(sellTicket, "买票人B");
        Thread thread3 = new Thread(sellTicket, "买票人C");
        thread1.start();    //3.启动线程
        thread2.start();
        thread3.start();
    }


}

