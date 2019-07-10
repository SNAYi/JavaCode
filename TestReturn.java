/**
 * @Author: snayi
 * @CreateTime: 2019-07-10 11:03
 * @Description:
 */
public class TestReturn {
    private static void funReturn(){
        for (int i = 0; i < 3; i++) {
            System.out.println("i的值是："+i);
            if (i==1){
                return;
            }
            System.out.println("return 后的输出语句");
        }
    }
    public static void main(String[] args) {
        funReturn();
    }
}
