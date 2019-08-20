package com.snayi;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-19 18:17
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException {
        CaseLoader loader = new CaseLoader();
        loader.load().run();
    }
}
