package com.snayi.collection;/**
 *
 */

import java.util.*;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/7/1 上午 10:45
 */


public class TestListIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();  //创建好List，并给集合放入内容
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("China");

    //方式1：迭代器输出
        System.out.println("方式1：迭代器输出");
        Iterator<String> iterator = list.iterator();    //取得list的迭代器

        //迭代输出list的内容
        while (iterator.hasNext()) {
            String str1 = iterator.next();
            System.out.println(str1);
        }

    //方式2：foreach输出
        System.out.println("方式2：foreach输出");
        for (String str2 : list) {
            System.out.println(str2);
        }

        System.out.println("方式3：listIterator输出");
    //方式3：只有list有
        ListIterator<String> listIterator = list.listIterator();    //取得list的迭代器

        //正向输出list的内容
        while (listIterator.hasNext()) {
            String str1 = listIterator.next();
            System.out.println(str1);
        }
        System.out.println("-----------");
        //反向输出
        while (listIterator.hasPrevious()){
            String str2 = listIterator.previous();
            System.out.println(str2);
        }

        System.out.println("方式4.Enumeration输出,只有vector有");
    //方式4.Enumeration输出,只有vector有
        Vector<String> list2 = new Vector<>();  //创建好List，并给集合放入内容
        list2.add("hello");
        list2.add("world");
        list2.add("hello");
        list2.add("China");
        Enumeration<String> enumeration = list2.elements();

        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

    }
}
