package jdbc01;

import java.sql.*;

public class JDBCDemo2 {

    public static void main(String[] args) throws Exception{
        //1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 建立连接
        String url = "jdbc:mysql://localhost:3306/db4?characterEncoding=UTF-8";
        Connection con = DriverManager.getConnection(url, "root","19970830");

        //3. 获取语句执行平台对象
        Statement statement = con.createStatement();

        //4. 执行查询操作
        String sql = "select * from jdbc_user;";
        ResultSet resultSet = statement.executeQuery(sql);
        //System.out.println(resultSet);
        //处理结果集对象
//        boolean next = resultSet.next();
//        System.out.println(next);

        //获取id
//        int id = resultSet.getInt("id"); //通过列名的方式获取
//        System.out.println(id);
//        int anInt = resultSet.getInt(1);
//        System.out.println(anInt);
        //通过while循环 遍历数据
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            Date birthday = resultSet.getDate("birthday");
            System.out.println(id + " : " + username + " : " + password + " : " + birthday );
        }


        resultSet.close();
        statement.close();
        con.close();
    }
}
