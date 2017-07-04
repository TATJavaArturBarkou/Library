package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.service.IClientService;

import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class SignUp extends Command {

	int email = 1;
	int password = 2;

	@Override
	public String execute(String request) {
		String[] requestData = request.split("&");
		
		User user = new User(requestData[email], requestData[password]);

		String response = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		IClientService clientService = factory.getClientService();

		try {

			clientService.signUp(user);
		} catch (ServiceException e) {
			response = e.getMessage();
			System.out.println("log: " + e.getMessage());
			e.printStackTrace();
		}

		// response of all operation
		return response;
	}

}
