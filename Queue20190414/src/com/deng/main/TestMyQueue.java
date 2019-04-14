package com.deng.main;/**
 *
 */

import com.deng.dao.MyQueueImpl;

/**
 * @auther deng
 * @date 2019/4/14 下午 04:24
 */


public class TestMyQueue {
    public static void main(String[] args) {
        MyQueueImpl myQueue =new MyQueueImpl();
        //System.out.println(myQueue.empty());
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);
        System.out.println(myQueue.size());//5
        System.out.println(myQueue.poll());//1
        System.out.println(myQueue.peek());//2
        System.out.println(myQueue.size());//4
    }
    }
