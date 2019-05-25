package com.deng.choose; /**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/25 下午 06:13
 */


public class Title9 {

    public static void main(String args[])throws InterruptedException{
        Thread t=new Thread(new Runnable() {
            public void run() {
                try {

                    Thread. sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("2");
            }
        });
        t.start();
        t.join();
        System.out.print("1");
    }


}
