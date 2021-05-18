package com.lagou.testpool;

import com.lagou.utils.DBCPUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDBCP {

    /*
    测试连接池
     */
    public static void main(String[] args) throws SQLException {
        //1. 从DBCP连接池中拿到连接
        Connection con = DBCPUtils.getConnection();
        Statement statement = con.createStatement();
        String sql = "select ename from employee";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String ename = resultSet.getString("ename");

            System.out.println(ename);
        }
        DBCPUtils.close(con, statement,resultSet);
    }
}
