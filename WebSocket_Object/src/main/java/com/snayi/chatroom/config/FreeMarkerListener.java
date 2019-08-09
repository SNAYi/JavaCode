package com.snayi.chatroom.config;

import freemarker.template.Configuration;
import javafx.collections.SetChangeListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-09 17:14
 * @Description:  全局资源存放
 */
//表示具备监听器能力
@WebListener
public class FreeMarkerListener implements ServletContextListener {
    public static final String TEMPLATE_KEY = "_template_";
    //tomcat调用  环境初始化
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //配置版本
        Configuration conf = new Configuration(Configuration.VERSION_2_3_0);
        //配置加载*.ftl的路径
        try {
            conf.setDirectoryForTemplateLoading(
                    new File("C:\\Users\\11411\\Desktop\\web_object\\src\\main\\webapp")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        //配置页面编码
        conf.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
        //配置写入上下文
        sce.getServletContext().setAttribute(TEMPLATE_KEY,conf);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
