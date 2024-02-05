package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* 수업목표. 해당 DBMS와 계정에 맞는 Connection 객체를 생성할 수 있다.(feat. DBMS Driver 추가) */
public class Application1 {
    public static void main(String[] args) {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "swcamp", "swcamp");
//          con은 통로라고 생각하면된다. 자바에서 디비로 값들을 전달해 왔다갔다하는 통로역할
            System.out.println("con = " + con);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(con != null && !con.isClosed())
                    con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
