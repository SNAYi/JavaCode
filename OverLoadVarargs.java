/**
 * @Author: snayi
 * @CreateTime: 2019-07-17 23:12
 * @Description:
 */
public class OverLoadVarargs {
    public void test(String s) {
        System.out.println("这是只有一个参数的test方法");
    }
    public void test(String...args) {
        System.out.println("这是可变参数的test方法");
    }
    public static void main(String[] args) {
        OverLoadVarargs o = new OverLoadVarargs();
        //重载方法
        o.test("aa","bb");
        o.test();
        //一个参数的test方法
        o.test("a");
        //这样调用的就是参数可变的重载方法
        o.test(new String[]{"AA"});
    }
}
