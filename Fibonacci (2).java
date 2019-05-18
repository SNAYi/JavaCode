package 递归和循环; /**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/15 下午 08:23
 */

//大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项
// （从0开始，第0项为0）。
//n<=39
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

    //采用迭代实现
    //1.采用数组实现
    public static int Fibonacci1(int n) {
        int[] array = new int[100];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
    //采用变量移动实现
    public static int Fibonacci2(int n) {
        int a =1;
        int b = 1;
        int temp = 0;
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            for (int i = 3; i <= n; i++) {
                temp = a + b;
                a = b;
                b = temp;
            }
            return temp;
        }
    }
}
