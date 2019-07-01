package com.snayi.map;/**
 *
 */

import java.util.*;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/7/1 下午 02:31
 */


public class MapIterator {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();

        //Map.Entry<key,value>
        map.put(1,"hello");
        map.put(2,"world");
        map.put(3,"hello");
        map.put(4,"java");
        map.put(5,null);

        //map->set
    //map的标准输出
        Set<Map.Entry<Integer,String>> set = map.entrySet();

        //取得迭代器
        Iterator<Map.Entry<Integer,String>> iterator = set.iterator();

        //迭代输出
        while (iterator.hasNext()) {
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
