package com.deng.main;/**
 *
 */


import com.deng.dao.LinkedStack;
import com.deng.impl.Stack;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/19 下午 09:10
 */


public class TestLinkedStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());    //5
        System.out.println(stack.pop());    //5
        System.out.println(stack.size());    //4
        System.out.println(stack.peek());    //4
    }
}
