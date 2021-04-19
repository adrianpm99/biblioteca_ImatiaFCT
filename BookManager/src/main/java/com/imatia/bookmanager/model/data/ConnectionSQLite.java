package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionSQLite {

	private static Connection connection = null;

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		if (connection == null) {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:database.db");
		}
		return connection;
	}// getConnection

	public void closeConnection() throws SQLException {

		if (connection != null) {
			connection.close();
			connection = null;
		}
	}// closeConnection
}
