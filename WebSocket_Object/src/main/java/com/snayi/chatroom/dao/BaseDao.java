package com.snayi.chatroom.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.snayi.chatroom.utils.CommUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-09 08:54
 * @Description: 封装基础操作，数据源，获取连接，关闭资源
 */
public class BaseDao {
    private static DataSource dataSource;
    static {
        //加载配置文件
        Properties properties = CommUtils.loadProperties("datasource.properties");
        try {
            //1.加载数据源
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.out.println("数据源加载失败");
            e.printStackTrace();
        }
    }
    //获取连接，让子类获取
    protected Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("获取连接失败");
            e.printStackTrace();
        }
        return null;
    }
    //关闭资源
    protected void closeResources(Connection connection, Statement statement) {
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
    protected void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
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
