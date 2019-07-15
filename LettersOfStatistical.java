

/**
 * @Author: snayi
 * @CreateTime: 2019-07-14 23:41
 * @Description: 输入一行字符串，计算并输出其中A~Z出现的个数
 */
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //1.拿到字符串
            String s = sc.nextLine();
            //2.String->char[]
            char[] c = s.toCharArray();
            int len = c.length;
            //3.数组索引+65存放的是A~Z  数组内数据存放的是对应大写字母出现的次数
            int[] a = new int[26];

            //4.遍历出每个大写字母出现的次数
                //外层循环决定的是最终的纯字母数组的个数 要与数组a的大小对应上
            for (int i = 0; i < a.length; i++) {
                //内层循环遍历整个字符数组依次寻找A~Z出现的次数
                for (int j = 0; j < len; j++) {
                    //如果当前字符数组值等于纯字母数组索引+65，该索引对应数据+1
                    if (c[j] ==(i+65)) {
                        a[i]++;
                    }
                }
            }
            //5.依次输出所有字母出现次数
            for (int i = 0; i < a.length; i++) {
                System.out.println((char)(i+17+'0')+":"+a[i]);
            }
        }
    }
}
