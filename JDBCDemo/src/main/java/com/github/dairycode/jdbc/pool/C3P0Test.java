package com.github.dairycode.jdbc.pool;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;

import java.sql.Connection;

public class C3P0Test {
    // 方式一:
    @Test
    public void testGetConnection1() throws Exception {
        // 获取C3P0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql:///test");
        cpds.setUser("root");
        cpds.setPassword("");
        // 通过设置相关的参数,对数据库连接池进行管理
        // 设置初始时数据库连接池中的连接数
        cpds.setInitialPoolSize(10);

        Connection conn = cpds.getConnection();
        System.out.println(conn);

        // 销毁C3P0数据库连接池
        DataSources.destroy(cpds);
    }

    // 方式二: 使用配置文件
    @Test
    public void testGetConnection2() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }
}
