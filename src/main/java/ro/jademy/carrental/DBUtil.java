package ro.jademy.carrental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static final String SERVER_URL = "localhost";
    public static final String SERVER_PORT = "3306";
    public static final String DB_NAME = "car_rental";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Password";

    public static Connection getConnection()
            throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://" + SERVER_URL + ":" + SERVER_PORT + "/" + DB_NAME + "?serverTimezone=UTC", USERNAME, PASSWORD);
    }
}
