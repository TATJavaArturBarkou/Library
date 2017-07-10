package by.epam.barkou.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.epam.barkou.dao.exception.DAOException;
import by.epam.barkou.dao.util.SQLConnection;

public class Fixture {
	private final static String SQL_CREATE_USERS = "CREATE TABLE books (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(40) UNIQUE, availability BOOL DEFAULT 1);";
	private final static String SQL_CREATE_ORDERS = "CREATE TABLE books (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(40) UNIQUE, availability BOOL DEFAULT 1);";
	private final static String SQL_CREATE_ORDERS_KEY = "CREATE TABLE books (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(40) UNIQUE, availability BOOL DEFAULT 1);";
	private final static String SQL_CREATE_BOOKS = "CREATE TABLE books (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(40) UNIQUE, availability BOOL DEFAULT 1);";
	private final static String SQL_DROP_TABLES = "DROP TABLE orders, users, books;";

	private SQLConnection sqlConnection = SQLConnection.getInstance();

	public void createClearDB() {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = sqlConnection.getConnection();
			ps = connection.prepareStatement(SQL_CREATE_BOOKS);
			ps.executeQuery();

		} catch (SQLException | DAOException e) {
			e.printStackTrace();

		} finally {
			if (ps != null || connection != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void dropDB() {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = sqlConnection.getConnection();
			ps = connection.prepareStatement(SQL_DROP_TABLES);
			ps.executeQuery();

		} catch (SQLException | DAOException e) {
			e.printStackTrace();

		} finally {
			if (ps != null || connection != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
