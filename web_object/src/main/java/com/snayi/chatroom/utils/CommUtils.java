package com.snayi.chatroom.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-01 10:14
 * @Description:   根据指定文件名加载配置文件 测试Json
 */
public class CommUtils {
    private static final Gson gson = new GsonBuilder().create();
    private CommUtils(){ }

    /**
     * 根据指定文件名加载配置文件
     * @param filename  配置文件名
     */
    public static Properties loadProperties(String filename) {
        Properties properties = new Properties();
        //获取到当前类的类加载器下所有同目录文件
        // CommmUtils.class.getClassLoader().getResourceAsStream();
        //获取当前配置文件夹下的文件输入流
        InputStream in = CommUtils.class.getClassLoader().getResourceAsStream(filename);
        //加载配置文件中的所有内容
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * obj->str
     * @param obj
     * @return
     */
    public static String obj2Json(Object obj) {
        return gson.toJson(obj);
    }
    //知道转换成哪种类型
    public static Object json2Obj(String string,Class objClass) {
        return gson.fromJson(string,objClass);
    }

    public static boolean StrIsEmpty(String string) {
        return string.equals(null) || string.equals("");
    }
}

