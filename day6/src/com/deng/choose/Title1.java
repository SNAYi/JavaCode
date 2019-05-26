package com.deng.choose;/**
 *
 */

import java.io.UnsupportedEncodingException;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/26 下午 07:53
 */


public class Title1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] src = {1,2,3,4,5};

        byte[] dsc;
        dsc = new String(src,"GBK").getBytes("UTF-8");
        System.out.println(dsc);
    }
}
