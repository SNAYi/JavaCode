package com.deng.main;/**
 *
 */

import com.deng.dao.MyStackImpl;

/**
 * @auther deng
 * @date 2019/4/14 下午 03:34
 */


public class TeatMyStack {
    public static void main(String[] args) {
        MyStackImpl myStack = new MyStackImpl();
        myStack.push(10);
        myStack.push(99);
        myStack.push(21);
        myStack.push(77);
        System.out.println(myStack.pop());//77
        System.out.println(myStack.peek());//21
        System.out.println(myStack.size());//3
    }
}
