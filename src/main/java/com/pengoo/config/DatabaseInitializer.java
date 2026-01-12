package com.pengoo.config;

import java.sql.*;

public class DatabaseInitializer {

    private final DatabaseConnection databaseConnection;

    public DatabaseInitializer(DatabaseConnection databaseConnection){
        this.databaseConnection = databaseConnection;
        initalizeDb();
    }

    private void initalizeDb(){
        String sql = """
        CREATE TABLE IF NOT EXISTS(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            title TEXT NOT NULL,
            description TEXT,
            importance INTEGER DEFAULT 0,
            complete BOOLEAN DEFAULT FALSE
                );
        """;

        try(Connection conn = databaseConnection.getConnection();
        Statement statement = conn.createStatement()){
            statement.execute(sql);

        } catch(SQLException e){
            throw new RuntimeException("Failed to get Connection");
        }

    }

}
