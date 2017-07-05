package by.epam.barkou.service;

import by.epam.barkou.bean.User;
import by.epam.barkou.service.exception.ServiceException;

public interface IClientService {
	void signIn(String login, char[] password) throws ServiceException;

	void signOut(String login) throws ServiceException;

	String signUp(User user) throws ServiceException;

}
