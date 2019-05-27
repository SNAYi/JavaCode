package com.deng.programming;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/27 下午 03:29
 */

/**
 * 求两个整数的最小公倍数(a,b)
 * 思路：
 * 1)最大公因数[a,b]
 * 2)已知(a,b)*[a,b] = a* b;
 * => (a,b) = a*b / [a,b];
 */

import java.util.*;
public class LeastCommonMultiple{

    /**
     * 利用辗转相除法求最大公因数
     * 1)a/b得到余数r 如果余数r为0，则b就是最大公因数。 2)如果余数r不为0，则用 b/r.
     * @param a 除数
     * @param b 被除数
     * @return
     */
    public static int gcd(int a,int b){    //a是除数 b是被除数
        int r = 0;    //余数
        if(a % b == 0) {    //出口
            return b;
        } else {
            r = a % b;
            return gcd(b,r);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int iMax = 0;    //最大公约数
        int mul = a*b;    //a和b的积
        if(a > b) {    //
            iMax = gcd(a,b);
        } else if(a == b){
            iMax = a;    //数相同，最大公约数就是本身
        } else {    // b > a
            iMax = gcd(b,a);
        }

        System.out.println(mul/iMax);
    }
}
