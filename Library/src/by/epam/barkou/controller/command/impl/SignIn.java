package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.controller.security.Encryptor;
import by.epam.barkou.service.IClientService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class SignIn extends Command {
	User user;
	public int accessLevel = 0;
	int email = 1;
	int password = 2;
	String response = null;

	@Override
	public String execute(String request) throws ControllerException {
		String[] requestData = request.split("&");

		String encryptedPassword = Encryptor.encrypt(requestData[password]);

		ServiceFactory factory = ServiceFactory.getInstance();
		IClientService clientService = factory.getClientService();

		try {

			user = clientService.signIn(requestData[email], encryptedPassword);

			if (user != null) {
				Controller.authorized_users.add(user);
				response = "User has been signed into system";
			} else {
				response = "Incorrect credentials";
			}

		} catch (ServiceException e) {
			response = e.getMessage();
			System.out.println("log: " + e.getMessage());
		}
		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}

	@Override
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;

	}

}
