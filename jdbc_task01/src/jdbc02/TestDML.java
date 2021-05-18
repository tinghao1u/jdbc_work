package jdbc02;

import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDML {

    /*
    插入数据
     */
    @Test
    public void testInsert() throws SQLException {

        //1. 通过jdbcUtils包 获取连接
        Connection con = JDBCUtils.getConnection();
        //2. 获取statement对象
        Statement statement = con.createStatement();

        //2.1 编写SQL
        String sql = "insert into jdbc_user values(null, '张百万', '123', '2020/11/11')";

        //2.2 执行SQL
        int i = statement.executeUpdate(sql);
        System.out.println(i);

        //3. 关闭流
        JDBCUtils.close(con, statement);
    }

    /*
    更新操作 根据id修改用户名
     */
    @Test
    public void testUpdate() throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        Statement statement = connection.createStatement();

        String sql = "update jdbc_user set username = '刘能' where id = 1";

        int i = statement.executeUpdate(sql);

        System.out.println(i);

        JDBCUtils.close(connection, statement);
    }

    /*
    删除操作
     */
    @Test
    public void testDelete() throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        Statement statement = connection.createStatement();

        String sql = "delete from jdbc_user where id in (1,2)";

        int i = statement.executeUpdate(sql);

        System.out.println(i);

        JDBCUtils.close(connection, statement);
    }
}
