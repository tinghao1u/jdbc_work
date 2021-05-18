package com.lagou.utils;

import org.apache.commons.dbcp.BasicDataSource;

import javax.security.auth.login.AccountLockedException;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DBCPUtils {

    //1. 定义常量, 保存数据库相关信息
    public static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/db5?characterEncoding=UTF-8";
    public static final String USER = "root";
    public static final String PASSWORD = "19970830";

    //2. 创建连接池对象(由DBCP提供的实现类)
    public static BasicDataSource dataSource = new BasicDataSource();

    //3. 适用静态代码块进行配置
    static {
        dataSource.setDriverClassName(DRIVERNAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setMaxActive(20);
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;

    }

    //5. 释放资源
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

    public static void close(Connection con, PreparedStatement preparedStatement){
        if (con != null && preparedStatement != null){
            try {
                preparedStatement.close();
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
