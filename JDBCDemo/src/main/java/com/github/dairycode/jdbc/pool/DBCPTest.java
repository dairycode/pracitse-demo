package com.github.dairycode.jdbc.pool;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPTest {

    // 测试DBCP的数据库连接池技术
    // 方式一:
    @Test
    public void testGetConnection1() throws SQLException {
        // 创建了DBCP的数据库连接池
        BasicDataSource source = new BasicDataSource();

        // 设置基本信息
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql:///test");
        source.setUsername("root");
        source.setPassword("");

        // 还可以设置其他涉及数据库连接池管理的相关属性
        source.setInitialSize(10);
        source.setMaxActive(10);
        // ...

        Connection conn = source.getConnection();
        System.out.println(conn);
    }

    // 方式二: 使用配置文件
    @Test
    public void testGetConnection2() throws Exception {
        Properties pros = new Properties();
        // 方式1:
        // InputStream is =ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        // 方式2:
        FileInputStream is = new FileInputStream(new File("src/main/resources/dbcp.properties"));
        pros.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(pros);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }
}
