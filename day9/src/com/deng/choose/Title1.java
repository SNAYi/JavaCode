package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/29 上午 09:17
 */


public class Title1 {
    public static void main(String[] args) {
        String x ="fmn";
        x.toUpperCase();    //x没改变，还是fmn
        String y = x.replace('f','F');  //y为Fmn
        y = y + "wxy";
        System.out.println(y);  //Fmnwxy
    }
}
