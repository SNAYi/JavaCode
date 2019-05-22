/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/22 下午 04:28
 */

class Base{
    Base() {
        System.out.print("base");
    }
}
public class Alpha  extends Base{
    public static void main(String[] args) {
        new Alpha();
        new Base();
    }
}
