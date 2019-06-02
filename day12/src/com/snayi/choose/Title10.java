package com.snayi.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/2 下午 07:03
 */


public class Title10 {
    public static void add(Byte b) {
        b = b++;
    }

    public static void test() {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a+" ");
        add(b);
        System.out.print(b+" ");
    }
    public static void main(String[] args) {
        test();
    }
}
