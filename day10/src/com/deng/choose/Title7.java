package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/29 下午 01:36
 */
class Person{
    String name = "no name";
    public Person(String nm) {
        name = nm;
    }
}
class EMP extends Person{
    String empID = "0000";
    public EMP(String id){
        //父类没有无参构造，必须要显式声明
        super(id);
        empID = id;
    }
}
public class Title7 {
    public static void main(String[] args) {
        EMP emp = new EMP("123");
        System.out.println(emp.empID);
    }
}
