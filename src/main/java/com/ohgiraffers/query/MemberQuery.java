package com.ohgiraffers.query;

import com.ohgiraffers.model.DTO.MemberDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.common.JDBCTemplate.close;

public class MemberQuery {
    public void insertMember(String name, int age, String id, String password) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/member-query.xml"));

            String query = prop.getProperty("signUp");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, id);
            pstmt.setString(4, password);

            pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);

        }
    }
    public void insertNonMember(String phone, String password) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/member-query.xml"));

            String query = prop.getProperty("insertNonMember");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, phone);
            pstmt.setString(2, password);

            pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);

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
    public void updateMileage(int mileage, String nowLoginMemberId) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result =0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/member-query.xml"));
            String query = prop.getProperty("updateLogin");

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, mileage);
            pstmt.setString(2, nowLoginMemberId);

            pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean loginCheck(String id, String password) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        Boolean check = false;

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECT id, password FROM tbl_member");

            while (rset.next()) {
                if (rset.getString("id").equals(id) && rset.getString("password").equals(password)) {
                    check = true;
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }

        return check;
    }

    public MemberDTO nowLoginMember(String id) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        MemberDTO member = new MemberDTO();

        String query = "SELECT * FROM tbl_member WHERE id = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            rset = pstmt.executeQuery();
            System.out.println();
            while (rset.next()) {
                if (rset.getString("id").equals(id)) {
                    member.setName(rset.getString("member_name"));
                    member.setAge(rset.getInt("member_age"));
                    member.setId(rset.getString("id"));
                    member.setPwd(rset.getString("password"));

                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }

        return member;
    }

    public boolean signUpIdCheck(String id) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Boolean check = false;

        String query = "SELECT ? FROM tbl_member";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                if (rset.getString("id").equals(id)) {
                    check = true;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
        return check;
    }
}
