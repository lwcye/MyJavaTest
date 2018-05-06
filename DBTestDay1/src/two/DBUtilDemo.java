package two;

import gjp.domain.ZhangWu;
import one.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DBUtilDemo {
    public static void main(String[] args) {
        queryBeanList();
    }

    /**
     * 插入数据
     */
    public static void insert() {
        try {
            //获取一个用来执行SQL语句的对象   QueryRunner
            QueryRunner qr = new QueryRunner();

            String sql = "INSERT INTO day01(id,username,password) VALUES(?,?,?)";
            Object[] params = {3, "TOM", "123456"};
            Connection conn = JDBCUtil.getConnection();
            int line = qr.update(conn, sql, params);// 用来完成表数据的增加、删除、更新操作
            //结果集处理
            System.out.println("line = " + line);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //获取一个用来执行SQL语句的对象   QueryRunner
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "INSERT INTO day01(id,username,password) VALUES(?,?,?)";
        Object[] params = {3, "TOM", "123456"};
        int line = 0;// 用来完成表数据的增加、删除、更新操作
        try {
            line = qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //结果集处理
        System.out.println("line = " + line);
    }

    /**
     * 更新数据
     */
    public static void update() {
        try {
            //创建一个QueryRunner对象，用来完成SQL语句的执行
            QueryRunner qr = new QueryRunner();
            //执行SQL语句
            String sql = "UPDATE day01 SET password = '1234' WHERE username=?";
            Object[] params = {"TOM"};
            Connection conn = JDBCUtil.getConnection();
            int line = qr.update(conn, sql, params);
            //结果集的处理
            System.out.println("line=" + line);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除数据
     */
    public void delete() {
        try {
            //创建一个QueryRunner对象，用来完成SQL语句的执行
            QueryRunner qr = new QueryRunner();
            //执行SQL语句
            String sql = "DELETE FROM day01 WHERE name = ?";
            Object[] params = {"股票收入"};
            Connection conn = JDBCUtil.getConnection();
            int line = qr.update(conn, sql, params);
            //结果集的处理
            System.out.println("line=" + line);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询数据
     */
    public static void query() {
        try {
            //创建一个QueryRunner对象，用来完成SQL语句的执行
            QueryRunner qr = new QueryRunner();
            //执行SQL语句
            String sql = "select * FROM day01";
            Object[] params = {};
            Connection conn = JDBCUtil.getConnection();
            Object[] query = qr.query(conn, sql, new ArrayHandler(), params);
            //结果集的处理
            System.out.println(query.length);
            System.out.println(Arrays.toString(query));

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询实体
     */
    public static void queryBean() {
        try {
            //创建一个QueryRunner对象，用来完成SQL语句的执行
            QueryRunner qr = new QueryRunner();
            //执行SQL语句
            String sql = "select * FROM day01 where id =?";
            Object[] params = {2};
            Connection conn = JDBCUtil.getConnection();
            day01Bean query = qr.query(conn, sql, new BeanHandler<>(day01Bean.class), params);
            //结果集的处理
            System.out.println(query);

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询实体列表
     */
    public static void queryBeanList() {
        try {
            //创建一个QueryRunner对象，用来完成SQL语句的执行
            QueryRunner qr = new QueryRunner();
            //执行SQL语句
            String sql = "select * FROM gjp_zhangwu";
            Object[] params = {};
            Connection conn = JDBCUtil.getConnection();
            List<ZhangWu> query = qr.query(conn, sql, new BeanListHandler<>(ZhangWu.class), params);
            //结果集的处理
            System.out.println(query);

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
