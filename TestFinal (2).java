/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/13 下午 11:08
 */
//1.final 修饰类 不能被继承
final class Test1{
    public void fun() {

    }
}
class Test2{
    //final 修饰属性属性变为常量，不能被修改
    public final Integer i= 1;
    i = 2;
    //final修饰方法 方法不能被覆写
    public final void fun() {

    }
}
public  class TestFinal extends Test2{
    public final void fun() {

    }

    public static void main(String[] args) {

    }
}


