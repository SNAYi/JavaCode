package com.deng.thread;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/30 下午 06:44
 */

class ThreadShutDown implements Runnable{
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            //判断当前线程是否被中断
            boolean bool = Thread.currentThread().isInterrupted();
            if (bool) {
                System.out.println("当前线程已被终止");
                return;
            }

            System.out.println(Thread.currentThread().getName()+",i="+(i++));
        }
        System.out.println("线程停止");
    }
}

public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
        ThreadShutDown shut = new ThreadShutDown();    //1.创建真实线程类实例
        Thread thread = new Thread(shut);    //2.创建代理线程类对象并传入真实对象；
        thread.start();    //3.启动线程

        Thread.sleep(1000);    //3.在主线程中调sleep，让主线程睡1秒
//        shut.setFlag(false);    //4.1调用真实线程类的set方法关闭线程
//        thread.stop();    //4.2Thread类的强制关闭，本方法会产生不完整数据
        thread.interrupt();    //4.3

    }
}
