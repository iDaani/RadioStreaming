import java.sql.*;
import java.util.HashMap;

/**
 * This class is to implement connect, select, insert and disconnect functionalities with MySQL Database.
 */
public class MySQLDao {

    private final static String DATABASE_URL = "jdbc:mysql://radiostream.mysql.database.azure.com:3306/radiostream?useSSL=true";
    private static String username;
    private static String password;
    private static Connection connection;
    private String tableName;

    MySQLDao(String username, String password, String tableName) {
        this.username = username;
        this.password = password;
        this.tableName = tableName;
    }

    public void start(String username, String password, String tableName) {
        new MySQLDao(username, password, tableName);
    }

    /**
     * Connect to the MySQL Database.
     */
    public boolean connect() throws SQLException {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, username, password);
            return connection.isValid(0);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    /**
     * Select queries from the MySQL Database and return them.
     */
    public HashMap<String, String> getQuery(String title, String artistName) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            String tableNameForQuery = "radiostream." + tableName;
            String selectSQL = String.format("SELECT * FROM %s WHERE title='%s' AND artistname='%s'", tableNameForQuery, title, artistName);
            ResultSet resultSet = stmt.executeQuery(selectSQL);
            HashMap<String, String> results = new HashMap<>();
            while (resultSet.next()) {
                results.put("Artist Name", resultSet.getString("artistname"));
                results.put("Song Title", resultSet.getString("title"));
                results.put("Song URL", resultSet.getString("spotifyurl"));
            }
            resultSet.close();
            return results;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    /**
     * Insert queries to the MySQL Database.
     */
    public int updateQuery(int counter, String title, String artistName, String songURL) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String insertSQL = String.format("INSERT INTO `radiostream`.`songs` (`idsongs`, `title`, `artistname`, `spotifyurl`) VALUES (%d, '%s', '%s', '%s')",
                    counter, title, artistName, songURL);
            return stmt.executeUpdate(insertSQL);

        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    /**
     * Close SQL Connectiom.
     */
    public void closeConnection() throws SQLException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
