package com.github.dairycode.jdbc.pool.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

    /**
     * @Description 使用C3P0的数据库连接池技术
     * @return
     * @throws SQLException
     */
    // 数据库连接池只需提供一个即可
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
    public static Connection getConnection1() throws SQLException {
        Connection conn = cpds.getConnection();
        return conn;
    }

    /**
     * @Description 使用DBCP的数据库连接池技术
     * @return
     * @throws Exception
     */
    private static DataSource source;
    static {
        Properties pros = new Properties();
        FileInputStream is = null;
        try {
            is = new FileInputStream(new File("src/main/resources/dbcp.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            pros.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection2() throws Exception {
        Connection conn = source.getConnection();
        return conn;
    }

    /**
     * @Description 使用Druid的数据库连接池技术
     * @return
     * @throws Exception
     */
    private static DataSource sources;
    static {
        Properties pros = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        try {
            pros.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            sources = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection3() throws Exception {
        Connection conn = sources.getConnection();
        return conn;
    }

    /**
     * 通过DbUtils关闭连接
     * @param conn
     * @param ps
     */
    public static void closeResource(Connection conn, Statement ps) {
//        try {
//            DbUtils.close(conn);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DbUtils.close(ps);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
    }

    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(rs);
    }
}
