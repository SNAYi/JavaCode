package com.snayi.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/26 下午 03:07
 */


public class Title4 {
    public static void fun1() {
        Title4 title4 = new Title4();
        title4.fun2();
        test.fun3();
    }
    public static void main(String[] args) {
        fun1();
    }

    public void fun2() {
        System.out.println("实例方法");
    }
}

class test{
    public static void fun3() {
        System.out.println("其他类的静态方法");
    }
}