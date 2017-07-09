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

	private final int ACCESS_LEVEL = 1;
	private final int EMAIL = 1;
	private final int PASSWORD = 2;
	private String response = null;
	private final int FIRST_USER = 0;
	
	@Override
	public String execute(String request) throws ControllerException {
		String[] requestData = request.split(SPLITTER);

		String encryptedPassword = Encryptor.encrypt(requestData[PASSWORD]);

		User user = new User(Controller.authorized_users.get(FIRST_USER).getId(),requestData[EMAIL], encryptedPassword);
		
		try {

				ServiceFactory factory = ServiceFactory.getInstance();
				IClientService clientService = factory.getClientService();
				response = clientService.updateProfile(user);
				
				Controller.authorized_users.clear();
				user = clientService.signIn(requestData[EMAIL], encryptedPassword);
				Controller.authorized_users.add(user);
				
		} catch (ServiceException e) {
			response = "Unable to update profile";
			System.out.println("log: " + e.getMessage());
		}

		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.ACCESS_LEVEL;
	}

}
