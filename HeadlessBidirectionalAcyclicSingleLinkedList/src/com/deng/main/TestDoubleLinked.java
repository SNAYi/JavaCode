package com.deng.main;/**
 *
 */

import com.deng.dao.DoubleLinkedImpl;

/**
 * @auther deng
 * @date 2019/4/20 上午 10:45
 */


public class TestDoubleLinked {
    public static void main(String[] args) {
        DoubleLinkedImpl doubleLinked = new DoubleLinkedImpl();
        doubleLinked.addFirst(18);
        doubleLinked.addFirst(68);
        doubleLinked.addFirst(99);
        doubleLinked.display(); //99 68 18
        doubleLinked.addIndex(3,78);
        doubleLinked.addIndex(1,78);
        doubleLinked.display(); //99 78 68 18 78
        doubleLinked.remove(68);
        doubleLinked.display(); //99 78  18 78
        doubleLinked.removeAllKey(78);
        doubleLinked.display(); //99 18
        System.out.println("===============");
        doubleLinked.clear();
        doubleLinked.display();
        System.out.println("===============");
    }
}
