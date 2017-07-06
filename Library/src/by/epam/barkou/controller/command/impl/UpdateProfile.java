package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.controller.security.Encryptor;

import by.epam.barkou.service.IClientService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class UpdateProfile extends Command {

	public int accessLevel = 1;
	int email = 1;
	int password = 2;
	String response = null;

	@Override
	public String execute(String request) throws ControllerException {
		String[] requestData = request.split("&");

		String encryptedPassword = Encryptor.encrypt(requestData[password]);

		User user = new User(Controller.authorized_users.get(0).getId(),requestData[email], encryptedPassword);
		
		try {

				ServiceFactory factory = ServiceFactory.getInstance();
				IClientService clientService = factory.getClientService();
				response = clientService.updateProfile(user);

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
