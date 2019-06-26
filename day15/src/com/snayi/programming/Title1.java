package com.snayi.programming;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/26 下午 04:10
 */

/**
 * 题目需求：不用运算符来实现加法操作
 *
 * 实现：位运算，递归实现。
 *      递归出口：B为0，即被加数为0.
 *      异或^ 与 求和 操作相似，只不过没有进位操作
 *      使用 按位与&  来产生进位效果
 */
public class Title1 {
        public static int addAB(int A, int B) {
            if(B == 0) {
                return A;   //出口
            } else {
                int sum = A^B;
                int carry = (A&B) << 1;
                return addAB(sum,carry);
            }
        }

    public static void main(String[] args) {
        System.out.println(addAB(1,2));
    }
}