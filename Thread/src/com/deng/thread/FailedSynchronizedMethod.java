package com.deng.thread;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-05 20:21
 * @Description:
 */
class Sync{
    public synchronized void test() {
        System.out.println(Thread.currentThread().getName()+"访问test开始");
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"访问test结束");
    }
}

public class FailedSynchronizedMethod extends Thread{

   private Sync sync;
   FailedSynchronizedMethod(Sync sync) {
       this.sync = sync;
   }

    @Override
    public void run() {
        //因为在这里产生了三个对象，各使用各的对象
        sync.test();
    }
    public static void main(String[] args) {
       Sync sync = new Sync();
        for (int i = 0; i < 3; i++) {
            //三个程序并发开始，没有锁住
            Thread thread = new FailedSynchronizedMethod(sync);
            thread.start();
        }
    }


}
