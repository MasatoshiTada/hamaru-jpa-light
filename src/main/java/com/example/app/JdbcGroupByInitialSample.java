package com.example.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcGroupByInitialSample {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String password = "app";
        String sql = "SELECT SUBSTR(NAME, ?, ?) AS INITIAL, NAME FROM MANUFACTURER";
        try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, 1);
            pst.setInt(2, 1);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String initial = rs.getString("INITIAL");
                String name = rs.getString("NAME");
                System.out.println(initial + ":" + name);
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
}
