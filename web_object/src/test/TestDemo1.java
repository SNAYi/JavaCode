import org.junit.Test;

import java.sql.*;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-31 21:21
 * @Description:
 */
public class TestDemo1 {
    @Test
    public void test() {

        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.建立连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "d970606,");
            //3.执行sql语句
            String sql = "select * from user";
                //获取执行sql的对象
            Statement statement = connection.createStatement();
                //获取执行结果集
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String passward = resultSet.getString("password");
                System.out.println(id+" "+username+" "+ passward);
            }

            //4.释放资源，关闭流
            connection.close();
            statement.close();
            resultSet.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
    @Test
    public void test4() {
        try {
            // 1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/jdbc",
                            "root","d970606,");
            // 3.执行SQL
            String sql = "select * from user" +
                    " where username = ? and password = ?";
            // 预编译SQL
            PreparedStatement statement =
                    connection.prepareStatement(sql);
            String userName = "zs or 1=1";
            String password = "123";
            statement.setString(1,userName);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            // 遍历结果集
            if (resultSet.next()) {
                System.out.println("登录成功！");
            }else {
                System.out.println("登录失败！");
            }
            // 4.释放资源
            connection.close();
            statement.close();
            resultSet.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
