package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.controller.security.Encryptor;
import by.epam.barkou.service.IClientService;

import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class SignUp extends Command {

	private final int ACCESS_LEVEL = 0;
	private final int EMAIL = 1;
	private final int PASSWORD = 2;
	private String response = null;

	@Override
	public String execute(String request) throws ControllerException {
		String[] requestData = request.split(SPLITTER);

		String encryptedPassword = Encryptor.encrypt(requestData[PASSWORD]);

		User user = new User(requestData[EMAIL], encryptedPassword);

		ServiceFactory factory = ServiceFactory.getInstance();
		IClientService clientService = factory.getClientService();

		try {

			response = clientService.signUp(user);
		} catch (ServiceException e) {
			response = "Unable to sign up";
			System.out.println("log: " + e.getMessage());
		}

		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.ACCESS_LEVEL;
	}

}
