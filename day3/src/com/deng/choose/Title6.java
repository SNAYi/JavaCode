package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/23 下午 05:52
 */


public class Title6 {
    public void print() {
        System.out.println("父类的实例方法");
    }
    public static void print2() {
        System.out.println("父类的类方法");
    }

    public static void main(String[] args) {
        Child child = new Child();

    }
}
class Child extends Title6{
    public void fun1() {
        super.print();
        super.print2();
        fun2();
        fun2();
        System.out.println("本类的实例方法");
    }
    public static void fun2() {
        System.out.println("本类的类方法");
    }
}
class OtherClass{
    public void fun3() {
        System.out.println("其他类的实例方法");
    }
}
