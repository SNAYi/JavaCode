package com.snayi.map;/**
 *
 */

import java.util.*;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/7/1 下午 02:01
 */


public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();

        //测试get set 方法

        //Map.Entry(key,value)
        map.put(1,"hello");
        map.put(2,"world");
        map.put(3,"hello");
        map.put(4,"java");
        map.put(4,"test");
        map.put(null,null);
        map.put(null,"嘿嘿");
        System.out.println(map.get(null));

        //测试keySet values 方法
        Set<Integer> keySet = map.keySet();    //取得所有key值
        Collection<String> values = map.values();    //取得所有value值

        //迭代输出key
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println(i+"="+map.get(i));
        }
        //System.out.println("-------------------");
/*        Iterator<String> stringIterator = values.iterator();
        while (stringIterator.hasNext()) {
            System.out.print(stringIterator.next()+" ");
        }*/
    }
}
