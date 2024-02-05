package com.ohgiraffers.section01.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application2 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        Connection con = null;

        try {
            prop.load(
                    new FileReader
                            ("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));
//            System.out.println("prop = " + prop);
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            // 길이 생성된것 -> 이렇게 해놓으면 url이나 user, password가 수정되어도 자바는 건들 필요가 없음
            System.out.println("con = " + con);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
        }

    }

    private static void close(Connection con) {
        try {
            if(con != null && !con.isClosed())
                con.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
