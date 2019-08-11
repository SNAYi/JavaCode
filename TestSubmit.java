package com.snayi.chatroom.dao;

import java.util.concurrent.*;
class RunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "、 " + i);
        }
    }
}
public class TestSubmit {
    public static void main(String[] args){
        RunnableThread runnableThread = new RunnableThread();
        ThreadPoolExecutor threadPoolExecutor =
        new ThreadPoolExecutor(3,5,
                2000,TimeUnit.MILLISECONDS,
        new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(runnableThread);
        }
    }
}