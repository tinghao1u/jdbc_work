package jdbc02;

import utils.JDBCUtils;

import java.sql.*;

public class TestDQL {

    // 查询姓名为张百万的一条记录
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from jdbc_user";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            Date birthday = resultSet.getDate("birthday");
            System.out.println(id + ": " + username + ", " + password + ", " + birthday);

        }
        JDBCUtils.close(connection,statement,resultSet);
    }
}
