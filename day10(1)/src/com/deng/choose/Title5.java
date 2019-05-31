package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/30 下午 07:43
 */

class Father{
    public Father() {
        System.out.println("父类的无参构造");
    }
}
public class Title5 extends Father{
    private  String name;

    public Title5() {
        System.out.println("Title5的无参构造");
    }

    public Title5(String name) {
        this();

        this.name = name;
    }
/*    static {
        super();
    }*/

    public static void main(String[] args) {
        Title5 title5 = new Title5("张三");
    }
}
