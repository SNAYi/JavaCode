package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/27 下午 08:54
 */


public class Title9 {
    static int a = 6;
    static {
        a += 9;
    }

    public static void main(String[] args) {
        System.out.println(a);
    }
    static{
        a /=3;
    }
}
