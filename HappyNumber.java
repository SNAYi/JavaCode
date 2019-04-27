/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/4/27 下午 03:15
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直
 * 到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数
 *
 * int ->String -> char[] -> char ->int
 * @count:已知count>1000 计算1000 次还不到1，就一定不是水仙花数
 * @result ：用来临时存储每一次计算结果
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy2(19));
    }
    public static boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        int num = n;
        int count = 0;
        while (num != 1){
            //每次result都要从0重新开始
            int result= 0;
            //valueOf() int-> String ,toCharArray: String ->char[]
            char[] chars = String.valueOf(num).toCharArray();
            for (int i = 0; i < chars.length; i++) {
                //new String:取得char[] 的 第i个字符，转成int
                int data = Integer.parseInt(new String(chars,i,1));
                //计算结果
                result += (data * data);
            }
            //计算次数+1
            count++;
            //本次的结果成为下次要拆分的数
            num = result;
            if (count > 1000) {
                return false;
            }
        }
        return true;
    }
    public static boolean isHappy2(int n) {
        if (n <= 0) {
            return false;
        }
        //用来存储每一次的计算结果
        Set<Integer> results = new HashSet<>();
        int num = n;
        while (num != 1){
            //每次result都要从0重新开始
            int result= 0;
            //valueOf() int-> String ,toCharArray: String ->char[]
            char[] chars = String.valueOf(num).toCharArray();
            for (int i = 0; i < chars.length; i++) {
                //new String:取得char[] 的 第i个字符，转成int
                int data = Integer.parseInt(new String(chars,i,1));
                //计算结果
                result += (data * data);
            }
            //本次的结果成为下次要拆分的数
            num = result;
            //计算结果重复
            if (results.contains(result)) {
                return false;
            } else {
                results.add(result); //将本次结果add进结果库
            }
        }
        return true;
    }
}
