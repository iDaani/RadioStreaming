import java.sql.*;
import java.util.HashMap;

public class MySQLDao {

    private static String username;
    private static String password;
    private String tableName;
    private static Connection connection;

    private final static String DATABASE_URL = "jdbc:mysql://radiostream.mysql.database.azure.com:3306/radiostream?useSSL=true";

    private MySQLDao(String username, String password, String tableName) {
        this.username = username;
        this.password = password;
        this.tableName = tableName;
    }

    public MySQLDao start(String username, String password, String tableName) {
        return new MySQLDao(username, password, tableName);
    }

    public static boolean connect() throws SQLException {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, username, password);
            return connection.isValid(0);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public static HashMap<String, String> getQuery(String key) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            String selectSQL = "SELECT * FROM radiostream WHERE title=" + key;
            ResultSet resultSet = stmt.executeQuery(selectSQL);
            HashMap<String, String> results = new HashMap<>();
            while (resultSet.next()) {
                results.put("Artist Name", resultSet.getString("artistname"));
                results.put("Song Title", resultSet.getString("title"));
                results.put("Song URL", resultSet.getString("spotifyurl"));
            }
            return results;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }



}
