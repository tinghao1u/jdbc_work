package jdbc01;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo01 {

    public static void main(String[] args) throws Exception {

        //1. 书册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db4?characterEncoding=UTF-8";
        Connection con = DriverManager.getConnection(url, "root","19970830");
//        System.out.println(con);

        //3. 获取语句执行平台 Statement
        Statement statement = con.createStatement();
        //3.1 statement对象的executeUpdate方法 创建一张表
        String sql = "create table test(id int, name varchar(20), age int);";
        int i = statement.executeUpdate(sql);//表示受影响的行数
        System.out.println(i);


        statement.close();
        con.close();


    }
}
