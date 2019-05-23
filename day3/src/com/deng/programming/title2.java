package com.deng.programming;/**
 *
 */

import java.util.Stack;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/23 上午 10:00
 */


public class title2 {
    private Stack<Character> stack;    //声明栈

    public title2() {
        stack =new Stack<>();    //实例化栈
    }

    public boolean chkParenthesis(String A, int n) {
        if (n <= 0) {
            return false;
        }
        char[] a = A.toCharArray();    //String->char[]
        n =a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] !='{' && a[i] !='}' && a[i] !='[' && a[i] !=']'
                    && a[i] !='(' && a[i] !=')') {    //出现除括号以外的符号
                return false;
            }
            if (a[i] == '{' || a[i] == '[' || a[i] == '(') {    //左括号入栈
                stack.push(a[i]);
            } else {    //是右括号
                if (stack.peek() == 0) {    //结果1：右括号多
                    return false;
                } else if (a[i] == '}' && stack.peek()== '{'||
                        a[i] == ']' && stack.peek()== '['||
                        a[i] == ')' && stack.peek()== '(') {    //匹配成功
                        stack.pop();
                } else {
                    return false;    //匹配不成功
                }
            }
            if (stack.peek() != 0) {    //左括号多
                return false;
            }
        }
        return true;
    }
}
