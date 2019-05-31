package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/30 下午 07:56
 */


public class Title7 {
    public static void main(String[] args) {
        byte b1=1,b2=2,b3,b6;
        char c1 = 1,c2 = 2;
        final byte b4 = 4,b5=6;

        b6 = b4+b5;
        b3 = (byte)(b1 + b2);
//        c1 = c2 + c1;  右边相加会自动整形提升成int
        System.out.println(b3+ b6);
    }
}
