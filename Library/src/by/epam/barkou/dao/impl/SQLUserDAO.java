package by.epam.barkou.dao.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.dao.IUserDAO;
import by.epam.barkou.dao.exception.DAOException;
import by.epam.barkou.dao.util.DBWorker;

public class SQLUserDAO implements IUserDAO {
	private DBWorker db = DBWorker.getInstance();
	User user;

	@Override
	public void signIn(String login, char[] password) throws DAOException {
		// select from...

	}

	@Override
	public String signUp(User user) throws DAOException {
		this.user = user;

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
		// TODO Auto-generated method stub

	}

}
