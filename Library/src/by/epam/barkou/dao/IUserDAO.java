package by.epam.barkou.dao;

import by.epam.barkou.bean.User;
import by.epam.barkou.dao.exception.DAOException;

public interface IUserDAO {
	void signIn(String login, char[] password) throws DAOException;

	String signUp(User user) throws DAOException;

	void signOut(String login) throws DAOException;
}
