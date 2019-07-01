package com.snayi.collection;/**
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/7/1 下午 04:05
 */


public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //相当于一次添加4个元素
        Collections.addAll(list,"hello","java","hello","world");
        System.out.println(list);

        //反转list
        Collections.reverse(list);
        System.out.println(list);
    }
}
