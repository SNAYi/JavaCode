package com.deng.programming;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/30 下午 08:47
 */
/**
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
 * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 */

import java.util.*;
public class Title1{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();

        int[] array = new int[1000000];    //斐波那契数列
        int a = 1;
        int b = 1;
        array[0] = a;
        array[1] = b;
        for(int i = 2;i <= 10;i++) {
            int temp = a + b;
            a = b;
            b = temp;
            array[i] = b;
        }

        int r1 = 0,r2 = 0;    //n和前后的差值
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {    //带查找数字就是数组的数字
                System.out.println(0);
                return;
            }
            if (array[i] > n){
                r1 = array[i] -n;
                r2 = n -array[i-1];
                break;
            }
        }
        if (r1 < r2) {
            System.out.println(r1);
        } else {
            System.out.println(r2);
        }
        }
}

/**
 * 最小浪费实现：
 * 一边生成斐波那契数列的同时一边比较
 */
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();

        //数列初始值，为了让1也参与比较，从0开始
        int a = 0;
        int b = 1;

        int left = 0,right = 0;    //保存n的左右两个数
        while(true) {
            int temp = a + b;
            a = b;
            b = temp;    //要被比较数
            if(b < n) {
                left = b;   //一直再更新n左边的数
            } else {
                right = b;    //如果一旦出现大于n的数，就一定是n右侧的数，直接跳出循环
                break;
            }
        }

        //比较left和right哪个距离n走的步数小，选择小的步数输出。
        System.out.println((n - left) < (right - n) ? (n - left):(right - n));
    }
}