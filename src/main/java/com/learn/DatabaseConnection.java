package com.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:postgresql://localhost:5432/librarydb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "2912"; 
    
    public static Connection getConnection() throws SQLException {
    	
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
