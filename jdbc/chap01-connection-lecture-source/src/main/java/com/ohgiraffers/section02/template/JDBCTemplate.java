package com.ohgiraffers.section02.template;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/* 설명. JDBC를 위한 메소드만 따로 모듈화(Connection 객체 생성, close메소드 처리(Connection, Statement, PreparedStatement) */
public class JDBCTemplate {
    // 어디서 호출하던 connection 객체를 만들어서 반환해줌
    public static Connection getConnection() {
        Connection con = null;
        Properties prop = new Properties();

        try {
            prop.load(
                    new FileReader
                            ("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            Class.forName(driver); // 어떤 이름을 가진 dbms를 가져다 쓸건지 선언

            /* 설명. 이번에는 'user'라는 키와 'password'라는 키 값을 지닌 properties 객체를 넘겨주고 Connection객체 생성 */
            con = DriverManager.getConnection(url, prop);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /* 설명. 이번에는 close 메소드를 여기서 호출하지 않는다.(해당 DBMS와 연결할 수 있는 Connection 반환만 해당되게 작성)  */

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
}
