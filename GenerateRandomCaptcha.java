package com.deng.main;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/10 下午 09:45
 */


public class GenerateRandomCaptcha {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            String str = (char)(Math.random()*26 + 97)+ " ";
            System.out.print(str+ " ");
        }

    }
}
