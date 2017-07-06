package by.epam.barkou.service.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.dao.IUserDAO;
import by.epam.barkou.dao.exception.DAOException;
import by.epam.barkou.dao.factory.DAOFactory;
import by.epam.barkou.service.IClientService;
import by.epam.barkou.service.exception.ServiceException;

public class ClientServiceImpl implements IClientService {
	DAOFactory daoObjectFactory = DAOFactory.getInstance();
	IUserDAO userDAO = daoObjectFactory.getUserDAO();
	User user;
	@Override
	public User signIn(String login, String password) throws ServiceException {
		// check parameters, e.g. length, special symbols
		
		if (login == null || login.isEmpty()) {
			throw new ServiceException("Incorrect login");
		}
		try {
			 user = userDAO.signIn(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return user;
	}

	@Override
	public void signOut(String login) throws ServiceException {
		// check parameters, e.g. length, special symbols
		try {
			userDAO.signOut(login);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public String signUp(User user) throws ServiceException {
		// check parameters, e.g. length, special symbols
		String response;
		try {
			response = userDAO.signUp(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return response;
	}

	@Override
	public String updateProfile(User user) throws ServiceException {
		// check parameters, e.g. length, special symbols
		String response;
		try {
			response = userDAO.updateProfile(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return response;
	}

}
