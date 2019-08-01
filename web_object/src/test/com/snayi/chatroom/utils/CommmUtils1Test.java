package com.snayi.chatroom.utils;

import com.snayi.chatroom.entity.User;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-01 10:17
 * @Description:
 */
public class CommmUtils1Test {
    @Test
    public void loadProperties() {
        String filename = "datasource.properties";
        Properties properties = CommmUtils1.loadProperties(filename);
        System.out.println(properties);
    }
    @Test
    public void gsonTest1() {
        User user = new User();
        user.setId(11);
        user.setUserName("test");
        user.setPassword("123");
        String jsonStr = (String) CommmUtils1.obj2Json(user);
        System.out.println(jsonStr);

    }
    @Test
    public void gsonTest2() {
        String jsonStr = "{\"id\":11,\"userName\":\"test\",\"password\":\"123\"}";
        User user = (User) CommmUtils1.json2Obj(jsonStr, User.class);
        System.out.println(user);
    }
}