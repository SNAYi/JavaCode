/**
 * @Author: snayi
 * @CreateTime: 2019-07-17 11:26
 * @Description: Variable args
 */
public class Varargs {
    public static void test(int a,String...words) {
        for (String s:words) {
            System.out.println(s);
        }
        System.out.println(a);
    }
    public static void main(String[] args) {
        //两者等效
        test(5,"可变参数测试","可变参数本质是数组参数");
        test(5,new String[]{"可变参数测试","可变参数本质是数组参数"});
    }
}
