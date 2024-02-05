package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection() {
        Connection con = null;
        Properties prop = new Properties();

        try {
            prop.load(
                    new FileReader
                            ("src/main/java/com/ohgiraffers/config/connection-info.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            Class.forName(driver); // 어떤 이름을 가진 dbms를 가져다 쓸건지 선언

            /* 설명. 이번에는 'user'라는 키와 'password'라는 키 값을 지닌 properties 객체를 넘겨주고 Connection객체 생성 */
            con = DriverManager.getConnection(url, prop);

            /* 설명. DML(insert, update, delete) 실행 시 커밋을 수동으로 하겠다는 설정 */
            con.setAutoCommit(false);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    public static void close(Connection con) {
        try {
            if(con != null && !con.isClosed())
                con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt) {
        try {
            if(stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset) {
        try {
            if(rset != null && !rset.isClosed())
                rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit(Connection con) {
        try {
            if(con != null && !con.isClosed())
                con.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(Connection con) {
        try {
            if(con != null && !con.isClosed())
                con.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
