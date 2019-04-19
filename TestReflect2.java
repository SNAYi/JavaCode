package com.deng.reflect;/**
 *
 */

import java.lang.reflect.Constructor;

/**
 * @auther deng
 * @date 2019/4/17 下午 08:54
 */

interface INews{}
interface IMessage{}
abstract class Fun{}
class RealClass extends Fun implements IMessage,INews{}
class Person{
    private String name;
    private  int age;

    private Person() {
    }

    protected Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class TestReflect {
    public static void main(String[] args) throws NoSuchMethodException {
        Class cls =Test.class;
        //取得包信息
        System.out.println(cls.getPackage());//package com.deng.reflect
        System.out.println(cls.getPackage().getName());//com.deng.reflect
        System.out.println("=================");
        Class cls1 =RealClass.class;
        //取得父类的Class对象
        System.out.println(cls1.getSuperclass());
        Class[] classes = cls1.getInterfaces();
        for (Class c:classes) {
            System.out.println(c);
        }
        System.out.println("=================");
        //
        Class cls2 = Person.class;
        //取得某个构造方法
        System.out.println(cls2.getConstructor(String.class,int.class));
        System.out.println("=================");
        {
            //取得权限为public的所有构造方法
            Constructor<?>[] constructors =cls2.getConstructors();
            for (Constructor c:
            constructors) {
                System.out.println(c);  //打印的是地址
            }
            //取得所有权限的构造方法
            Constructor<?>[] constructors1 =cls2.getDeclaredConstructors();
            for (Constructor c:
                    constructors1) {
                System.out.println(c);
            }

        }

    }
}
