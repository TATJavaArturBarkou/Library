package by.epam.barkou.dao.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.dao.IUserDAO;
import by.epam.barkou.dao.exception.DAOException;

public class SQLUserDAO implements IUserDAO {

	@Override
	public void signIn(String login, char[] password) throws DAOException{
		// Connect to db
		
	}

	@Override
	public void registration(User user) throws DAOException{
		// Connect to db
		
	}

	@Override
	public void signOut(String login) throws DAOException{
		// TODO Auto-generated method stub
		
	}

}
