package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * 1.class中的constructor可省略
 * 2.constructor必须与class同名，但方法也可以与class同名
 * 3.constructor在一个对象被new 时执行
 * @date 2019/5/22 下午 09:09
 */


public class Title8 {
    private Integer val;

    //构造器
    public Title8() {
    }
    //构造器
    public Title8(Integer val) {
        this.val = val;
    }
    //有类名同名的方法
    public static void Title8(int val) {
        System.out.println("val值为:"+val);
    }

    public static void main(String[] args) {
        Title8 title8 = new Title8();
        title8.Title8(10);
    }
}
