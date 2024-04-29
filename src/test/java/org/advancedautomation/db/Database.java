package org.advancedautomation.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/cucumberdb";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static ResultSet getLoginCredentials() throws SQLException {
		Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT username, password FROM login");
		return resultSet;
	}

	public static void insertData(String fname, String lname, String comp, String title) throws SQLException {
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
			String sql = "INSERT INTO leadcreation (FirstName, LastName, Company, Title) VALUES (?, ?, ?, ?)";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, fname);
				statement.setString(2, lname);
				statement.setString(3, comp);
				statement.setString(4, title);
				statement.executeUpdate();
			}
		}
	}
}