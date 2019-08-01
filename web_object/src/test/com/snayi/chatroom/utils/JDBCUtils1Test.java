package com.snayi.chatroom.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-01 09:46
 * @Description:
 */
public class JDBCUtils1Test {

    @Test
    /**
     * 查询
     */
    public void testQuery() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            //获取连接
            connection = JDBCUtils1.getConnection();
            String sql = "select * from user where id = ? and username = ?";
            //采用preparedStatement预编译和防止注入
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,3);
            preparedStatement.setString(2,"ww");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                System.out.println(id+" "+userName+" "+password);
            }
        }catch (SQLException e) {
        } finally {
            JDBCUtils1.closeResources(connection,preparedStatement,resultSet);
        }
    }
    @Test
    /**
     * 测试插入
     */
    public void testInsert() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //获取连接
            connection = JDBCUtils1.getConnection();
            //执行sql
            String sql = "insert into user(username,password) values(?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,"snayi");
            statement.setString(2, DigestUtils.md5Hex("snayi"));
            //接收受影响行数
            int influence = statement.executeUpdate();
            //采用断言判断影响行数
            Assert.assertEquals(1,influence);
            System.out.println("受影响行数为"+influence);
        } catch (SQLException e) {

        } finally {
            JDBCUtils.closeResources(connection,statement);
        }
    }

}