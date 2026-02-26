package com.example.demo;
import java.sql.*;
public class DemoApplication {
    public static void main(String[] args) {
        // PostgreSQL connection parameters
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "12345678";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql4 = """
                    DO $$
                    DECLARE
                     total integer; -- You must declare a variable to hold the math
                    BEGIN
                     total := 1 + 1;
                     RAISE NOTICE 'The total is: %', total;
                    END;
                    $$;
                    """;

            try (Statement stmt = conn.createStatement()) {

                stmt.execute(sql4);

                SQLWarning warning = stmt.getWarnings();
                while (warning != null) {
                    System.out.println("DB NOTICE2: " + warning.getMessage());
                    warning = warning.getNextWarning();
                }
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
