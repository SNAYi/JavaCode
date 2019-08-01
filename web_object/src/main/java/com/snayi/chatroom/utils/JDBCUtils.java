package com.snayi.chatroom.utils;

import java.sql.*;
import java.util.Properties;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-01 08:23
 * @Description: 封装JDBC操作的公共方法
 */
public class JDBCUtils {
    private static String driverName;
    private static String url;
    private static String uesrName;
    private static String password;

    //通过静态代码块在类加载时就加载配置，且只加载一次
    static {
        Properties properties = CommmUtils.loadProperties("db.properties");
        driverName = properties.getProperty("driverName");
        url = properties.getProperty("url");
        uesrName = properties.getProperty("userName");
        password = properties.getProperty("password");

        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("加载数据库驱动出错");
            e.printStackTrace();
        }
    }

    //获取数据库连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url,uesrName,password);
        } catch (SQLException e) {
            System.err.println("获取数据库连接出错");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭数据库资源操作
     * @param connection
     * @param statement
     */
    //关闭数据库update操作的流
    public static void closeResources(Connection connection, Statement statement) {
        if (connection != null) {
            try {
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
        closeResources(connection,statement);
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
