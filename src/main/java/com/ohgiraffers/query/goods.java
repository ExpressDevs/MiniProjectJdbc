package com.ohgiraffers.query;

import com.ohgiraffers.model.DTO.TicketDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

    public class goods {
        private String ticketNum;
        private String product;
        private int count;

        public String getTicketNum() {
            return ticketNum;
        }

        public void setTicketNum(String ticketNum) {
            this.ticketNum = ticketNum;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void insertTicketNum(String ticketNum)  {
            this.ticketNum = ticketNum;
        }
        public void insertTicketProduct(String product) {
            this.product = product;
        }

        public void insertTicketCount(int count) {
           this.count = count;
        }

        public void insertAll() {

            Connection con = getConnection();
            PreparedStatement pstmt = null;
            Properties prop = new Properties();

            try {
                prop.loadFromXML(
                        new FileInputStream("src/main/java/com/ohgiraffers/mapper/product-query.xml")
                );
                String query = prop.getProperty("insertProduct");
                pstmt = con.prepareStatement(query);
                pstmt.setString(1,ticketNum);
                pstmt.setString(2,product);
                pstmt.setInt(3,count);

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
