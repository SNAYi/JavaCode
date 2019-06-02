package com.snayi.programming;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/2 下午 07:39
 */


import java.util.*;

public class Title2 {
    public static String[] getGray(int n) {
        //1.声明要返回的格雷码数组
        String[] resStrs = null;
        //2.递归出口
        if(n == 1){
            resStrs = new String[]{"0","1"};
        }else{
            //3.通过递归拿到n-1的格雷码
            String[] strs = getGray(n-1);
            //4.n的格雷码位数为n-1的2倍
            resStrs = new String[2*strs.length];
            //5.每一次循环从两端处理格雷码
            for(int i=0; i<strs.length; i++){
                resStrs[i] = "0"+strs[i];
                resStrs[resStrs.length-1-i] = "1"+strs[i];
            }
        }
        return resStrs;
    }

    public static void main(String[] args) {
        String[] str = getGray(4);
        for (String i: str) {
            System.out.print(i + " ");
        }
    }
}
