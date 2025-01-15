package Utils;

import java.sql.*;

public class DatabaseUtils {

    private static final String DB_URL = "jdbc:sqlite:E:\\cucumber project\\src\\test\\java\\mydatabase.db"; // Path to your SQLite file

    public static Connection getConnection() throws  SQLException {
        // Establish a connection to the SQLite database
        return DriverManager.getConnection(DB_URL);
    }
}
