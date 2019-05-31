package com.deng.programming;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/29 下午 04:14
 */
/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 */

//自己直接求阶乘实现，也不知道问题出在哪里
/*import java.util.*;
public class Title1{
    public static int factorial(int n) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        } else {
            return n*factorial(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = factorial(n);

        int count = 0;
        if(result == 1 || result == 2) {
            System.out.println(0);
        } else {
            while(result != 0) {
                if(result % 10 == 0) {
                    count++;
                    result /= 10;
                } else {
                    break;
                }
            }
            System.out.println(count);
        }
    }
}*/
import java.util.*;
public class Title1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();	//1.取到n

        int count = 0;		//2.记录末尾0的个数

        //3.要n比5大，阶乘末尾才有0
        for(int i = n;i >=5;i--) {
            //如果在循环中要对控制循环的变量进行运算操作，最后产生它的副本，用副本操作，这样可以避免循环条件出问题。
            int temp = i;
            while(temp % 5 == 0) {    //能走到这的都是5的倍数
                count++;
                temp /= 5;
            }
        }

        System.out.println(count);    //返回末尾0的个数
    }
}
