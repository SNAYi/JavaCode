package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/26 下午 08:00
 */


public class Title6 {
    public static void main(String[] args) {
        new Son();
    }
}
class Father{
    {
        System.out.println("这是父类构造块");
    }
    static {
        System.out.println("这是父类静态块");
    }
}
class Son extends Father{
    {
        System.out.println("这是子类构造块");
    }
    static {
        System.out.println("这是子类静态块");
    }
}
