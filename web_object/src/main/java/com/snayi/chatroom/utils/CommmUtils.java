package com.snayi.chatroom.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-01 07:22
 * @Description:封装了基本的工具方法。如加载配置文件，json的序列化
 */
public class CommmUtils {
    private CommmUtils(){ }

    /**
     * 根据指定文件名加载配置文件
     * @param filename  配置文件名
     */
    public static Properties loadProperties(String filename) {
        Properties properties = new Properties();
        //获取到当前类的类加载器下所有同目录文件
        // CommmUtils.class.getClassLoader().getResourceAsStream();
        //获取当前配置文件夹下的文件输入流
        InputStream in = CommmUtils.class.getClassLoader().getResourceAsStream(filename);
        //加载配置文件中的所有内容
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
