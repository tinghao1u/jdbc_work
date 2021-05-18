package com.lagou.testpool;

import com.lagou.utils.C3P0Utils;

import java.sql.*;

public class TestC3P0 {

    public static void main(String[] args) throws SQLException {

        //1. 获取连接
        Connection connection = C3P0Utils.getConnection();


        //2. 获取预处理对象
        String sql = "select * from employee where ename = '李清照'";
        Statement statement = connection.createStatement();
        //preparedStatement.setString(1, "李清照");
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int eid = resultSet.getInt("eid");
            String ename = resultSet.getString("ename");
            int age = resultSet.getInt("age");
            String sex = resultSet.getString("sex");
            double salary = resultSet.getDouble("salary");
            Date empdate = resultSet.getDate("empdate");
            System.out.println(eid + ", " + ename + ", " + age + ", " + sex + ", " + salary + ", " + empdate);
        }

        C3P0Utils.close(connection, statement, resultSet);
    }
}
