package com.deng.thread;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-05 20:37
 * @Description:
 */
class Sync1{
    public  void test() {
        synchronized(Sync1.class){
            System.out.println(Thread.currentThread().getName()+"访问test开始");
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"访问test结束");
        }
    }
}

public class SuccessSync extends Thread{


    @Override
    public void run() {
        //因为在这里产生了三个对象，各使用各的对象
        Sync1 sync1 =new Sync1();
        sync1.test();
    }
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            //三个程序并发开始，没有锁住
            Thread thread = new SuccessSync();
            thread.start();
        }
    }


}
