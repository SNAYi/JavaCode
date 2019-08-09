package com.snayi.chatroom.dao;

import com.snayi.chatroom.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;
import java.util.Collection;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-09 09:06
 * @Description: 用户模块的dao
 */
public class AccountDao extends BaseDao{
    //用户注册--insert
    public boolean userRegister(User user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isSuccess = false;
        try {
            connection = getConnection();
            String sql = "insert into user(username,password) values(?,?)";
            //String sql = "insert into user(username,password)"+"values(?,?)";
            //返回主键受影响的行数Statement.RETURN_GENERATED_KEYS
            statement =connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,userName);
            statement.setString(2,DigestUtils.md5Hex(password));
            //判断是否插入进去
            isSuccess = (statement.executeUpdate()== 1);
        } catch (Exception e) {
            System.out.println("用户注册失败");
            e.printStackTrace();
        } finally {
            closeResources(connection,statement);
        }
        return isSuccess;
    }
    //用户登录--select
    public User userLogin(String userName,String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try{
            connection = getConnection();
            //String sql = "select * from user where username = ? and password=?";
            String sql = "select * from user where username = ? "+"and password=?";
                  statement = connection.prepareStatement(sql);
                  //具体替换
                  statement.setString(1,userName);
                    //将密码加密
                  statement.setString(2, DigestUtils.md5Hex(password));
                  resultSet = statement.executeQuery();
                  //将resultset结果封装起来，在多层传递
                  if (resultSet.next()) {
                      user = getUserInfo(resultSet);
                  }
        } catch (Exception e){
            System.err.println("查询用户信息出错");
            e.printStackTrace();
        }finally {
            closeResources(connection,statement,resultSet);
        }
        return user;
    }

    //将数据表信息封装到user类中
    public User getUserInfo(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUserName(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
