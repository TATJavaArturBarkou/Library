package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.controller.secure.Encryptor;
import by.epam.barkou.service.IClientService;

import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;


public class SignUp extends Command {

	int email = 1;
	int password = 2;
	String response = null;
	@Override
	public String execute(String request) throws ControllerException {
		String[] requestData = request.split("&");

		String encryptedPassword = Encryptor.encrypt(requestData[password]);

		
		User user = new User(requestData[email], encryptedPassword);

		ServiceFactory factory = ServiceFactory.getInstance();
		IClientService clientService = factory.getClientService();

		try {

			response = clientService.signUp(user);
		} catch (ServiceException e) {
			response = e.getMessage();
			System.out.println("log: " + e.getMessage());
		}

		return response;
	}

}
