package com.snayi.com.snayi.properties;/**
 *
 */

import java.io.*;
import java.util.Properties;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/7/1 下午 03:36
 */


public class TestProperties {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        /*properties.setProperty("bj","北京");
        properties.setProperty("xa","西安");
        properties.setProperty("sh","上海");
        properties.setProperty("wh","武汉");

        System.out.println(properties.getProperty("xa"));
        System.out.println(properties.getProperty("nj"));   //没有返回null
        System.out.println(properties.getProperty("nj","城市"));

    //将属性资源持久化到外部文件
        File file = new File("D:\\Java\\Collection" +
                "\\src\\resources\\test.properties");

        properties.store(new FileOutputStream(file),"first comment");*/

    //从外部文件加载配置
       //File file = new File("D:\\Java\\Collection" +"\\src\\resources\\test.properties");
        //取得文件路径可替换为(通过反射直接取得输入流)
        InputStream in = TestProperties.class.getClassLoader().getResourceAsStream("test.properties");

        //properties.load(new FileInputStream(file));
        properties.load(in);

        System.out.println(properties.getProperty("xa"));
        System.out.println(properties.getProperty("wh"));
    }
}
