package com.deng.programming;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/1 下午 01:04
 */



import java.util.*;
public class Title1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n =s.length();
        int[] a = new int[10];

        for(int i = 0;i < n;i++) {
            a[s.charAt(i)-'0']++;    //增加对应下标的个数
        }
        for(int i = 0;i < a.length;i++) {
            if(a[i] != 0){
                System.out.println(i+":"+a[i]);
            }
        }
    }
}

/*import java.util.Scanner;
public class Title1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[10];
        String n = in.next();
        for(int i = 0;i<n.length();i++)
            a[n.charAt(i)-'0']++;
        for(int i = 0;i<a.length;i++)
            if(a[i]!=0)
                System.out.println(i+":"+a[i]);
    }
}*/
