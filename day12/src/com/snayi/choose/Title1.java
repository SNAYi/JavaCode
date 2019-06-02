package com.snayi.choose;
/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/2 下午 04:21
 */

class Father{
    private String name;
    private int age;

    public String getInfo() {
        return "Father{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Son extends Father{
    private Character gender;
    private String address;

    //覆写：发生在有继承关系的类之间
    //要求：方法名相同；返回值类型相同；参数的个数即类型完全相同
    @Override
    public String getInfo() {
        return "Son{" +
                "gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }

    public Son(Character gender) {
        this.gender = gender;
    }
    //重载：发生在一个类之间
    //要求：方法名相同,参数的类型和个数不同
    public Son(Character gender, String address) {
        this.gender = gender;
        this.address = address;
    }
}
public class Title1 extends Father{
    public static void main(String[] args) {
        Father son = new Son('男',"陕西西安");
        //测试覆写
        System.out.println(son.getInfo());
        //测试重载
        System.out.println(new Son('女').getInfo());
    }
}
