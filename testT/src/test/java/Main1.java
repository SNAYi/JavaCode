/**
 * @Author: snayi
 * @CreateTime: 2019-08-17 17:57
 * @Description:   字符串中找出连续最长的数字串
 *                  使用三个变量来实现，
 *                  max表示最长数字串的长度，
 *                  endIndex指向最长数字串的最后一个下标
 *                  count表示当前子串的长度，如果当前数字串的长度大于max,则当前数字串成为最大数字串
 */
import java.util.*;
public class Main1{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int max = 0;
        int endIndex = 0;
        int count = 0;
        for(int i = 0;i < str.length();i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                count ++;
                if(max < count) {
                    max = count;
                    endIndex = i;
                }
            } else {
                count = 0;
            }
        }
        String result = str.substring(endIndex-max+1,endIndex+1);
        System.out.println(result);
    }
}
