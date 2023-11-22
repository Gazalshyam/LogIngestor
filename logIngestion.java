//logIngestion.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class logIngestion {
    private static final String URL = "jdbc:postgresql://localhost:5432/myLogs";
    private static final String USER = "postgres";//enter your username
    private static final String PASSWORD = "gazalshyam18";//enter your password

    public static void insertLog(String level, String message, String resourceId) {
        try {
            Class.forName("postgresql.jdbc.driver.Driver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO logs (level, message, resourceId, timestamp) VALUES (?, ?, ?, CURRENT_TIMESTAMP)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, level);
                statement.setString(2, message);
                statement.setString(3, resourceId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
