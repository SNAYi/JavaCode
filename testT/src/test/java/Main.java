/**
 * @Author: snayi
 * @CreateTime: 2019-08-16 22:30
 * @Description:
 */
import java.util.*;
public class Main {
    public static int bottleNum(int n){
        //计算瓶子数量
        int count = 0;
        if(n <= 1) {
            return count;
        } else {
            while(n > 2){
                count += n/3;
                //没有用的瓶子+喝剩下的瓶子
                n = (n%3)+(n/3);
            }
            if(n == 2) {
                count ++;
            }
            return count;
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            System.out.println(bottleNum(n));
        }
    }
}