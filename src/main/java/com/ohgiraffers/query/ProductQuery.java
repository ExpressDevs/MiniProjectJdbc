package com.ohgiraffers.query;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class ProductQuery {

    public void insertGoods(String ticketNum, String goods, int goods_count) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/product-query.xml"));
            String query = prop.getProperty("insertGoods");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, ticketNum);
            pstmt.setString(2, goods);
            pstmt.setInt(3, goods_count);

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

}
