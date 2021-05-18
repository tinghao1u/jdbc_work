package com.lagou.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0Utils {
    //适用的配置是默认配置
    //public static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    //适用指定的配置
    public static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

    //获取连接的方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(Connection con, Statement statement){
        if (con != null && statement != null){
            try {
                statement.close();
                //归还连接给连接池
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection con, Statement statement, ResultSet resultSet){
        if (con != null && statement != null){
            try {
                resultSet.close();
                statement.close();
                //归还连接给连接
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
