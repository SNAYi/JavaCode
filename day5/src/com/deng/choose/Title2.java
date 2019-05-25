package com.deng.choose; /**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/25 下午 05:49
 */


public class Title2 {
    public static void main(String[] args) {
        StringBuffer a=new StringBuffer("A");
                StringBuffer b=new StringBuffer("B");
                operate(a,b);
        System.out.println(a+"."+b);
    }
    static void operate(StringBuffer x,StringBuffer y) {
        x.append(y);
        y=x;
    }
}
