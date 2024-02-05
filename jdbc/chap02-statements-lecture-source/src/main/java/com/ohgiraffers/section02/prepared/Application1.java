package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {

            /* 설명. Statement와 달리 PreparedStatement는 생성 당시에 쿼리가 있어야 한다. */
            pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");
            // 완전히 완성되어있는 쿼리 같은 경우에는 statement가 더 낫다
            // 쿼리를 입력받아야 할 경우에는 prepareStatement가 더 낫다.
            // prepareStatement는 sql injection을 막을 수 있다.
            rset = pstmt.executeQuery();

            while(rset.next()) {
                System.out.println(rset.getString("EMP_ID")
                        + ", " + rset.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);   // Statement를 close하는 애로 인식되어서 작동중
            close(con);
        }
    }
}
