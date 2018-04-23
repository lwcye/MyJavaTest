package one;

import com.mysql.jdbc.ConnectionGroupManager;
import com.mysql.jdbc.Driver;

import java.sql.*;

public class DBdemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*
        注册
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 链接数据库
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, username, password);
        */

        //插入数据u
        //insertData(connection);

        //查询数据
        queryData(JDBCUtil.getConnection());
    }

    /**
     * 查询数据
     *
     * @param connection
     */
    private static void queryData(Connection connection) throws SQLException {
        //3.获得预处理对象
        String sql = "select * from day01";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //4.SQL占位符设置数据
        //5.执行SQL语句
        ResultSet resultSet = preparedStatement.executeQuery();
        //6.打印结果
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println(id + username + password);
        }

        //7.关闭
        connection.close();
        preparedStatement.close();
        resultSet.close();
    }

    /**
     * 插入数据
     *
     * @param connection
     * @throws SQLException
     */
    private static void insertData(Connection connection) throws SQLException {
        // 3. 获得预处理对象
        String sql = "insert into day01(id,username,password) values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 4.SQL语句占位符设置实际参数
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, "n");
        preparedStatement.setString(3, "2");
        // 5.执行SQL语句
        int i = preparedStatement.executeUpdate();
        System.out.println("新添加记录数：" + i);

        // 6.释放资源
        preparedStatement.close();
        connection.close();
    }


}
