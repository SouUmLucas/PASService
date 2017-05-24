package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		final String URL = "jdbc:postgresql://localhost:5432/PASService";
		final String USER = "lucas";
		final String PASSWORD = "admin";
		final String DRIVER = "org.postgresql.Driver";
		
		Class.forName(DRIVER);		
		Connection conn;
		conn = DriverManager.getConnection(URL, USER, PASSWORD);	
		
		return conn;
	}
}
