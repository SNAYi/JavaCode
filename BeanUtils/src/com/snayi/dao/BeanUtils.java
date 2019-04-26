package com.snayi.dao;/**
 *
 */

import java.lang.reflect.Field;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/4/26 下午 10:45
 */


public class BeanUtils {
    public static void copy(Object source, Object target) throws IllegalAccessException {
        //1.通过Field赋值
        //2.通过setter赋值
        //1.参数校验
        if (source == null || target == null) {
            throw  new IllegalArgumentException("source or target can`t be null");
        }
        //2.获取source和target的Class对象
        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();
        //3.获得source和target的Field对象
        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();

        //4.进行属性赋值
        for (Field sf: sourceFields) {
            for (Field tf: targetFields) {
                //名称类型都相同才赋值
                if (sf.getName().equals(tf.getName()) && sf.getType().equals(tf.getType())) {
                    //动态破坏封装
                    sf.setAccessible(true);
                    tf.setAccessible(true);
                    //取得source值
                    Object object = sf.get(source);
                    //将source值给target
                    tf.set(target,object);
                }
            }
        }
    }
}