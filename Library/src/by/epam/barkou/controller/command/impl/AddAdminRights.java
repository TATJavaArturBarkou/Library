package by.epam.barkou.controller.command.impl;

import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.service.IClientService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class AddAdminRights extends Command{

	public int accessLevel = 2;
	int userId = 1;

	String response = null;

	@Override
	public String execute(String request) throws ControllerException {
		String[] requestData = request.split("&");

		try {
				ServiceFactory factory = ServiceFactory.getInstance();
				IClientService clientService = factory.getClientService();
				response = clientService.addAdminRights(requestData[userId]);
				
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
