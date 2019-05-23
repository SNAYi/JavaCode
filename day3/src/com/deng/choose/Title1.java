package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/23 上午 08:40
 */


class Person {
    private String name = "Person";
    int age = 0;
}
// name可以在com.deng.choose.Person中访问private
public class Title1 extends Person {
    public static void main(String[] args) {
        Person p = new Title1();
        //System.out.println(p.name);
        System.out.println(p.age);
    }


}
