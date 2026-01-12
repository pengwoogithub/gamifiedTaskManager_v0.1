package com.pengoo.config;

import java.sql.*;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:taskmanager.db";

    public Connection getConnection()throws SQLException{
        return DriverManager.getConnection(URL);
    }

}
