package Day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task1 {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:sample.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connection to SQLite has been established.");
                System.out.println("Connection Object: " + conn);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

