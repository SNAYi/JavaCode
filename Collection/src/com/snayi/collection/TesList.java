package com.snayi.collection;/**
 *
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/7 下午 08:56
 */


public class TesList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(1);
        System.out.println(list);   //覆写了toString方法  1 3 5 7 1
        System.out.println(list.size());    //5
        System.out.println(list.contains(7));   //true
        System.out.println(list.set(3,9));    //1 3 5 9 1 返回7
        System.out.println(list.get(3));    //9
        System.out.println(list.remove(4));    //调用的是List的remove    删除了最后的1
        System.out.println(list.remove(new Integer(5)));    //调用的是Collection的remove  删除值5

    }
}
