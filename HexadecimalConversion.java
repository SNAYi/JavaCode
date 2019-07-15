/**
 * @Author: snayi
 * @CreateTime: 2019-07-15 10:59
 * @Description: 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 */
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            //1.拿到带0x前缀的16进制数
            String hex = sc.nextLine();
            //2.以0xA为例，分解为"0","A"
            String[] s = hex.split("x");
            //3.取A然后将其转换为10
            int dec = Integer.parseInt(s[1],16);
            System.out.println(dec);
        }
    }
}
