package com.deng.thread;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/30 下午 06:02
 */

class Sleep implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+",i="+i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
public class TestSleep  {
    public static void main(String[] args) {
        Runnable runnable = new Sleep();
        (new Thread(runnable)).start();
        (new Thread(runnable)).start();
        (new Thread(runnable)).start();
        System.out.println("主线程执行完毕");
    }
}
