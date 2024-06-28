package spring_basic.hellospring.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn;

        String url = "jdbc:mysql://localhost:3306/App";
        String id = "root";
        String password = "root";

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, id, password);

        return conn;
    }
}