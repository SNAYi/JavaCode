package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/23 下午 05:21
 */

class Base{
    public Base(String s){
        System.out.print("B");
    }
}
public class Title2 extends Base{
    public Title2 (String s) {
        super(s);    //如果父类没有隐式构造，则一定要显式表名你用的是父类的那个有参构造。
        System.out.print("D");
    } public static void main(String[] args){
        new Title2("C");
    }
}

