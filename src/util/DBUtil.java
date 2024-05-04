package util;

import java.sql.*;

public class DBUtil {

    public static Connection getConnection(String DBurl, String user, String pass) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DBurl, user, pass);
    }
}
