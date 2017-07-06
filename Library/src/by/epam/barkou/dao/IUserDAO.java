package by.epam.barkou.dao;

import by.epam.barkou.bean.User;
import by.epam.barkou.dao.exception.DAOException;

public interface IUserDAO {
	User signIn(String login, String password) throws DAOException;

	String signUp(User user) throws DAOException;

	void signOut(String login) throws DAOException;

	String updateProfile(User user) throws DAOException;

	String addAdminRights(String string) throws DAOException;

	String setUserBanned(String id, String bannedValue) throws DAOException;
}
