/**
 * @Author: snayi
 * @CreateTime: 2019-08-12 23:08
 * @Description:
 */
public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("a");
        StringBuffer b = new StringBuffer("b");
        swap(a,b);
        System.out.println(a+"、"+b);
    }
    public static void swap(StringBuffer x,StringBuffer y) {
        x.append(y);
        y = x;
    }
}
