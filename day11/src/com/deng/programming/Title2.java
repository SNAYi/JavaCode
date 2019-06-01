package com.deng.programming;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/1 上午 10:54
 */


import java.util.ArrayList;
public class Title2 {
    public int[] multiply(int[] A) {
        int n = A.length;
        ArrayList<Integer> B = new ArrayList<>();

        int count = n;
        int temp = 1;
        while(count > 0) {
            for(int i = 0;i < n;i++) {
                if(i == B.size()) {
                    continue;
                } else {
                    temp *=A[i];
                }
            }
            B.add(temp);
            count--;

        }
        int[] c = new int[B.size()];
        for(int i = 0;i < B.size();i++) {
            c[i] = B.get(i);
        }
        return c;
    }
}

class Solution {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] b = new int[n];

        int temp =1;    //用来存放a[i]的乘积
        for(int i = 0;i < n;i++) {    //1.判断循环次数
            for(int j = 0;j < n;j++) {    //2.遍历相乘，得到b[i]值
                if(j == i) {
                    continue;
                } else {
                    temp *= A[j];
                }
            }
            b[i] = temp;
            temp = 1;
        }
        return b;
    }
}
