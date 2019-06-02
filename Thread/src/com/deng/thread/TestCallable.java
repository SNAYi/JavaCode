package com.deng.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/21 下午 07:54
 */

class MyThread3 implements Callable<String> {
    private Integer ticket = 20;
    @Override
    public String call() throws Exception {
        while (this.ticket > 0) {
            System.out.println(Thread.currentThread().getName()+"当前剩余票数为"+this.ticket--);
        }
        return "票已售完，下次赶早~";
    }
}
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.有一个MyThread3对象
        MyThread3 myThread3 = new MyThread3();
        //2.有一个FutureTask对象接收callable 的返回值
        FutureTask<String> futureTask =new FutureTask<>(myThread3);
        //3.有一个Thread对象来启动线程
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());

    }
}
