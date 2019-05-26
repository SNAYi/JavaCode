package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/26 下午 08:04
 */


public class Title7 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(test(num));
    }

    public static int test(int b) {
        try {
            b += 10;
            return b;
        } catch(RuntimeException e) {

        } catch(Exception e2) {

        } finally {
            b += 10;
            return b;
        }
    }
}
