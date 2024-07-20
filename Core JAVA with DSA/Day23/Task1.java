package Day23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task1 {
    private static Task1 instance;
    private Connection connection;

    private Task1() {
        try {
            // Assume we are using SQLite for demonstration purposes
            String url = "jdbc:sqlite:sample.db";
            this.connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Task1 getInstance() {
        if (instance == null) {
            synchronized (Task1.class) {
                if (instance == null) {
                    instance = new Task1();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

