package com.zhanziwei.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DruidDataSource dataSource;
    static {    // 静态代码块，随着类的加载而执行，只执行一次，并优先于主函数
        Properties properties = new Properties();   // 使用properties文件来加载程序需要的配置信息
        // 以流的形式通过类加载器在classpath下获取资源
        InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");  // 实现获取在classpath路径下的资源文件的输入流
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = dataSource.getConnection();
        return conn;
    }

    public static void close(Connection conn) throws SQLException {
        if(conn != null) {
            conn.close();
        }
    }
}
