package com.lagou.testBatch;

import com.lagou.utils.DBCPUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchInsert {

    public static void main(String[] args) throws SQLException {

        Connection con = DBCPUtils.getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("insert into testBatch(uname) values(?)");

        for (int i = 0; i < 1000; i++){
            preparedStatement.setString(1, "小强" + i);
            preparedStatement.addBatch();
        }

        long start = System.currentTimeMillis();

        preparedStatement.executeBatch();

        DBCPUtils.close(con, preparedStatement);

        long end = System.currentTimeMillis();

        System.out.println("time" + (end - start));
    }
}
