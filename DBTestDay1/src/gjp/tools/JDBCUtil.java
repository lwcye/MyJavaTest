package gjp.tools;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtil {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    /*
     * 创建连接池BasicDataSource
     */
    public static BasicDataSource dataSource = new BasicDataSource();

    // 静态代码块
    static {
        try {
            // 1 使用Properties处理流
            // 使用load()方法加载指定的流
            Properties props = new Properties();
            Reader is = new FileReader("db.properties");
            props.load(is);
            // 2 使用getProperty(key)，通过key获得需要的值，
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");

            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 返回连接池对象
     *
     * @return BasicDataSource
     */
    public static BasicDataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获得连接
     */
    public static Connection getConnection() {
        try {
            // 1 注册驱动
            Class.forName(driver);
            // 2 获得连接
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}