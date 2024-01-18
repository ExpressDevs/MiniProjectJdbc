package com.ohgiraffers.query;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.common.JDBCTemplate.close;

public class MemberQuery {
    public void insertMember(String name, int age, String id, String password) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        int result =0;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/member-query.xml"));

            String query = prop.getProperty("signUp");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, id);
            pstmt.setString(4, password);

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);

        }

        if (result > 0) {
            System.out.println("회원 가입 성공");
        } else {
            System.out.println("회원 가입 실패");
        }
    }

    public void updateLogin(int login, String nowLoginMemberId) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result =0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/member-query.xml"));
            String query = prop.getProperty("updateLogin");

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, login);
            pstmt.setString(2, nowLoginMemberId);

            pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
