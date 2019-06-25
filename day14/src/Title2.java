/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/25 下午 10:18
 */



import java.io.IOException;
        import java.io.BufferedReader;
        import java.io.InputStreamReader;

public class Title2{
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);    //将输入的字节流转换为字符流
        BufferedReader bf = new BufferedReader(isr);    //缓冲区输入流

        String s ;

        while((s = bf.readLine()) != null) {
            int m = Integer.valueOf(s);    //将读进来的字符串转换为数字
            int head = m*(m-1)+1;    //首项的值
            System.out.print(head);
            for(int i = 1; i < m;i++) {
                System.out.print("+"+(head +=2));
            }
            System.out.println();
        }
        bf.close();
    }


}