package Day21;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:sample.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                createTable(conn);
                Scanner scanner = new Scanner(System.in);
                
                System.out.print("Enter User ID: ");
                String userId = scanner.nextLine();
                
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();
                String hashedPassword = hashPassword(password);

                insertUser(conn, userId, hashedPassword);

                System.out.print("Enter User ID to verify: ");
                String verifyUserId = scanner.nextLine();
                
                System.out.print("Enter Password to verify: ");
                String verifyPassword = scanner.nextLine();
                String verifyHashedPassword = hashPassword(verifyPassword);

                if (checkUser(conn, verifyUserId, verifyHashedPassword)) {
                    System.out.println("Access granted.");
                } else {
                    System.out.println("Access denied.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS User ("
                + " UserID TEXT PRIMARY KEY,"
                + " Password TEXT NOT NULL"
                + ");";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    public static void insertUser(Connection conn, String userId, String password) throws SQLException {
        String sql = "INSERT INTO User(UserID, Password) VALUES(?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        }
    }

    public static boolean checkUser(Connection conn, String userId, String password) throws SQLException {
        String sql = "SELECT * FROM User WHERE UserID = ? AND Password = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

