/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/15 下午 08:23
 */


public class Fibonacci {
    public static void main(String[] args) {
        int n = Fibonacci(6);
        System.out.println(n);
    }
    //递归实现，下标从1开始
    public static int Fibonacci(int n) {
        int result = 0;
        if(n <= 0) {
            return -1;
        }else  if(n == 1||n == 2) {
            return 1;
        } else {
                result = Fibonacci(n - 1) + Fibonacci(n - 2);
        }
        return result;
    }
    public static int Fibonacci1(int n) {
        int[] array = new int[100];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
