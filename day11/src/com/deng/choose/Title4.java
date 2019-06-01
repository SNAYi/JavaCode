package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/31 下午 06:34
 */


public class Title4 {
    public static void main(String[] args) {
        Thread t = new Thread(){
          public void run() {
              pong();
          }
        };
        t.run();
        System.out.print("ping");
    }
    static public void pong() {
        System.out.print("pong");
    }
}
