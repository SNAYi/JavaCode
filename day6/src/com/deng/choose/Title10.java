package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/26 下午 05:07
 */


public class Title10 {
    public static void main(String[] args) {
        boolean b = true ? (true == true ? true:false) : false;    //true
        System.out.println(b);
        boolean c=true?false:true==true?false:true;    //false
        System.out.println(c);
    }
}
