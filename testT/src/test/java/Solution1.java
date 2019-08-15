import org.junit.Test;

import java.util.*;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-14 23:32
 * @Description: 判断回文
 */
public class Solution1 {

    //判断是否是回文串，双指针法
    public static boolean isHuiWen(String str){
        int left = 0;
        int right = str.length()-1;
        while(left < right){
            //为相遇前出现不相等值
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            //向中间移动
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //被插入串
        String A = in.nextLine();
        //插入串
        String B = in.nextLine();

        //记录插入成功的方式
        int count = 0;
        //确保可以从A的第一个字符前一个取到A的最后一个字符后一个位置
        for(int i = 0;i <= A.length();i++){
            StringBuffer sb = new StringBuffer(A);
            sb.insert(i,B);
            if(isHuiWen(sb.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
}
