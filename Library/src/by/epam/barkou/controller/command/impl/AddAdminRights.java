package by.epam.barkou.controller.command.impl;

import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.service.IClientService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class AddAdminRights extends Command {

	private final int ACCESS_LEVEL = 2;
	private final int USER_ID = 1;
	private String response = null;

	@Override
	public String execute(String request) throws ControllerException {
		String[] requestData = request.split(SPLITTER);

		try {
			ServiceFactory factory = ServiceFactory.getInstance();
			IClientService clientService = factory.getClientService();
			response = clientService.addAdminRights(requestData[USER_ID]);

		} catch (ServiceException e) {
			response = "Not able to add admin rights";
			System.out.println("log: " + e.getMessage());
		}

		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.ACCESS_LEVEL;
	}

}
