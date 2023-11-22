//logSearch
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class logSearch{
  //logSearch
    private static final String URL = "jdbc:postgresql://localhost:5432/myLogs";
    private static final String USER = "postgres";//enter your username
    private static final String PASSWORD = "gazalshyam18";//enter your password


    public static List<String> searchLogs(String level, String message, String resourceId) {
        List<String> results = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM logs WHERE 1=1");

            if (level != null && !level.isEmpty()) {
                sqlBuilder.append(" AND level = ?");
            }
            if (message != null && !message.isEmpty()) {
                sqlBuilder.append(" AND message LIKE ?");
            }
            if (resourceId != null && !resourceId.isEmpty()) {
                sqlBuilder.append(" AND resourceId = ?");
            }

            try (PreparedStatement statement = connection.prepareStatement(sqlBuilder.toString())) {
                int parameterIndex = 1;

                if (level != null && !level.isEmpty()) {
                    statement.setString(parameterIndex++, level);
                }
                if (message != null && !message.isEmpty()) {
                    statement.setString(parameterIndex++, "%" + message + "%");
                }
                if (resourceId != null && !resourceId.isEmpty()) {
                    statement.setString(parameterIndex, resourceId);
                }

                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    results.add(resultSet.getString("message"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}
