package com.snayi.chatroom.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-01 07:39
 * @Description:
 */
public class CommmUtilsTest {

    @Test
    public void loadProperties() {
        String filename = "db.properties";
        Properties properties = CommmUtils.loadProperties(filename);
/*        String url = properties.getProperty("url");
        Assert.assertNotNull(url);*/
    }

}