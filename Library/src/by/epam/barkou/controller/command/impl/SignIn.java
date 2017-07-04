package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.Book;
import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.service.IClientService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;


public class SignIn extends Command {

	@Override
	public String execute(String request) {

		
		String login = null;
		char[] password = null;

		String response;

		ServiceFactory factory = ServiceFactory.getInstance();
		IClientService clientService = factory.getClientService();

		try {
			clientService.signIn(login, password);
			
			//Controller.authorized_users.add();
			 
			response = "Welcome";
		} catch (ServiceException e) {
			response = "Error during login procedure";
		}

		return response;
	}

}
