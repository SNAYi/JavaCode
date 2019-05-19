import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/19 下午 04:22
 */


public class TestSystemIn {
    public static void main(String[] args) throws IOException {
        InputStream in =System.in;
        System.out.println("请输入：");
        byte[] data = new byte[2048];
        int len = in.read(data);
        System.out.println("输出为："+new String(data,0,len));

    }
}
