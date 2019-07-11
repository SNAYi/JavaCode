/**
 * @Author: snayi
 * @CreateTime: 2019-07-10 12:12
 * @Description: print triangle
 *     *
 *    ***
 *   *****
 *  *******
 */
public class PrintTriangle {
    public static void main(String[] args) {
        //三角形为4行
        int n =4;
        //确定三角形行数
        for (int i = 0; i < n; i++) {
            //输出空格,空格数为n-i+1个
            for (int j = 0; j < (n-i-1); j++) {
                    System.out.print(" ");
            }
            //输出*，*数为2i+1个
            for (int j = 0; j < (2*i+1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
