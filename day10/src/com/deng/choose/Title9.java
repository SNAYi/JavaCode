package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/29 下午 02:14
 */


public class Title9 {
    String str = new String("hello");
    char[] ch ={'a','b'};

    public  void change(String str,char[] ch) {
        str ="test ok";
        ch[0] = 'c';
    }

    public static void main(String[] args) {
        Title9 title9 = new Title9();
        title9.change(title9.str,title9.ch);
        System.out.print(title9.str + " and ");
        System.out.print(title9.ch);
    }
}
