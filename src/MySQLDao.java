import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public static void connect() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
