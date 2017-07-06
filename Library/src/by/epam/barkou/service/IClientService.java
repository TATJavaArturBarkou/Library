package by.epam.barkou.service;

import by.epam.barkou.bean.User;
import by.epam.barkou.service.exception.ServiceException;

public interface IClientService {
	User signIn(String login, String encryptedPassword) throws ServiceException;

	void signOut(String login) throws ServiceException;

	String signUp(User user) throws ServiceException;

	String updateProfile(User user) throws ServiceException;

}
