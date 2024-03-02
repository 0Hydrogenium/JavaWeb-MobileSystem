package com.MobileSystem.util;

import java.sql.*;

public class SqlDriver {
    public final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public final String DB_NAME = "MobileSystem";
    public final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?characterEncoding=utf-8&rewriteBatchedStatement=true";
    public final String USER_NAME = "root";
    public final String USER_PASSWORD = "20021121";

    public ResultSet executeRead(String sql) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            return rs;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeWrite(String sql) {
        Connection conn;
        Statement stmt;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}