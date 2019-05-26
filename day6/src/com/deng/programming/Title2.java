package com.deng.programming;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/26 下午 06:40
 */

import java.util.*;
public class Title2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();    //1.取得字符串
        String[] temp = str.split(" ");    //2.以空格拆分,去空格操作

        int[] array = new int[temp.length];    //3.String[] ->int[]
        int n = array.length;
        for (int i = 0; i < n; i++) {
            array[i] = Integer.valueOf(temp[i]);         //3.1取到所有数据
        }
        int num = array[0];    //4.从第一个数开始找
        int count = 0;
        for (int j = 1; j < n; j++) {
            if (array[j] == num) {    //4.1遍历数组的找相同值得个数
                count++;
            }
            if (count >= n/2) {    //4.2.1同时判断当前值得个数有没有超过半数，超过则直接输出
                break;
            } else {    //4.2.2否则num后移
                num = array[j];
            }
        }
        System.out.println(num);
    }
}
/*import java.util.*;
public class Title2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.valueOf(strs[i]);
            }
            int num = arr[0];
            int count = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == num) {    //计算出了num的个数
                    count++;
                }
                if (count >= arr.length/2) {
                    break;
                } else {
                    num = arr[j];
                }
            }
            System.out.println(num);

    }
}*/
