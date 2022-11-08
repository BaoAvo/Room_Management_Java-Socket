package server.dao;

import java.sql.Connection;
import java.sql.*;

public class ConnectDB {
    protected Connection conn;

    public ConnectDB() {
        String url = "jdbc:mysql://localhost:3306/caro?useSSL=false";
        String username = "root";
        String password = ""; //please change information to connect to DB
        try {
            String classNameJDBC = "com.mysql.cj.jdbc.Driver";
            Class.forName(classNameJDBC);
            conn = DriverManager.getConnection(url, username, password);//connect to database
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Connection to database failed");
        }
    }
}
