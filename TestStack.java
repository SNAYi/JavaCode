package com.deng.main;/**
 *
 */

import com.deng.dao.StackImpl;
import com.deng.impl.Stack;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/19 下午 08:48
 */


public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new StackImpl<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.peek());    //5
        System.out.println(stack.pop());    //5
        System.out.println(stack.size());    //4
        System.out.println(stack.peek());    //4
    }
}
