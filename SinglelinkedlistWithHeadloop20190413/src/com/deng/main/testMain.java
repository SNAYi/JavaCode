package com.deng.main;/**
 *
 */

import com.deng.dao.CLinkedImpl;

/**
 * @auther deng
 * @date 2019/4/13 下午 07:17
 */


public class testMain {
    public static void main(String[] args) {
        //产生头节点
        CLinkedImpl list = new CLinkedImpl();
        list.addFirst(12);
        list.addFirst(33);
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(5);//2 1 33 12 5
        list.display();
        list.addIndex(2,4);// 2 1 4 33 12 5
        list.display();
        list.addIndex(0,1);//1 2 1 4 33 12 5
        list.display();
        System.out.println(list.getLength());//7
        System.out.println(list.contains(1));//true
        System.out.println(list.remove(4));//
        list.remove(33);
        list.display();//1 2 1 4  12 5
        list.removeAllKey(1);
        list.display();// 2  4  12 5
        System.out.println("==========");
        list.clear();
        list.display();
        System.out.println("==========");
    }

}
