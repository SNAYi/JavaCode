package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/30 下午 07:50
 */


public class Title6 {
    public static void main(String[] args) {
        try {
            int a = 100;
            System.out.println(a/0);
        } catch (Exception e) {
            System.out.println(1);
            throw new RuntimeException();
        } finally {
            System.out.println(2);
        }
        System.out.println(3);
    }
}
