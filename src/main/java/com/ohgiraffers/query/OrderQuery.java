package com.ohgiraffers.query;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.common.JDBCTemplate.close;

public class OrderQuery {

    public void insertOrder(String ticketNum, String id, String departureStation, String arrivalStation, String departureTime, int billingAmount, String paymentMethod, int totalAmount) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/order-query.xml"));

            String query = prop.getProperty("insertTicketNum");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, ticketNum);
            pstmt.setString(2, id);
            pstmt.setString(3, departureStation);
            pstmt.setString(4, arrivalStation);
            pstmt.setString(5, departureTime);
            pstmt.setInt(6, billingAmount);
            pstmt.setString(7, paymentMethod);
            pstmt.setInt(8, totalAmount);

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
