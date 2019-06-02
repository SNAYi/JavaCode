package com.snayi.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/2 下午 04:41
 */

import java.io.FileNotFoundException;

/**
 * 字符串常量在编译期间被确定
 * 字符串常量相加还是字符串常量
 *
 */
public class Title4 {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "he"+ new String("llo");
        String str3 = "he"+ "llo";
        System.out.println(str1 == str2);   //false
        System.out.println(str1 == str3);   //true

    }
}
