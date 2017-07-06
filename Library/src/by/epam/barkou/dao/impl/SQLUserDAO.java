package by.epam.barkou.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import by.epam.barkou.bean.User;

import by.epam.barkou.dao.IUserDAO;
import by.epam.barkou.dao.exception.DAOException;
import by.epam.barkou.dao.util.DBWorker;

public class SQLUserDAO implements IUserDAO {
	private DBWorker db = DBWorker.getInstance();
	User user;

	@Override
	public User signIn(String login, String password) throws DAOException {

		String query;

		query = "SELECT * FROM `users` where email='" + login + "' and password='" + password + "';";

		try {

			ResultSet db_data = this.db.getDBData(query);
			while (db_data.next()) {

				user = new User(db_data.getString("id"), db_data.getString("email"), db_data.getString("password"),
						Integer.parseInt(db_data.getString("role")));

			}

			return user;

		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error while making sql operation");
		}
	}

	@Override
	public String signUp(User user) throws DAOException {
		String query;

		query = "INSERT INTO `users` (`email`,`password`) VALUES ('" + user.getEmail() + "', '" + user.getPassword()
				+ "')";

		Integer affected_rows = this.db.changeDBData(query);

		if (affected_rows > 0) {
			//
		} else {
			throw new DAOException("Error while making sql operation");
		}
		return "User is registred successfully";
	}

	@Override
	public void signOut(String login) throws DAOException {

	}

	@Override
	public String updateProfile(User user) throws DAOException {
		String query;

		query = "UPDATE `users` SET `email` = '" + user.getEmail() + "',`password` = '" + user.getPassword() + "' WHERE `id` = " + user.getId();

		Integer affected_rows = this.db.changeDBData(query);

		if (affected_rows > 0) {
			
		} else {
			throw new DAOException("Error while making sql operation");
		}
		return "User is updated successfully";
	}

}
