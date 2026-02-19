package com.example.demo;

import java.sql.*;
public class DemoApplication {
    public static void main(String[] args) {
        // PostgreSQL connection parameters
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "12345678";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to PostgreSQL database!");
            // Create statement
            Statement stmt = conn.createStatement();
            // Execute query
            String sql = "SELECT * FROM classicmodels.customers LIMIT 5";
            ResultSet rs = stmt.executeQuery(sql);
            // Get metadata
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();
            // Print column names
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metadata.getColumnName(i) + "\t");
            }
            System.out.println("\n" + "-".repeat(50));
            // Process results
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
