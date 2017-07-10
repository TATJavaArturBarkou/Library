package by.epam.barkou.controller.command.impl;

import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.service.IClientService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class SetUserBanned extends Command {

	private final int accessLevel = 2;
	private final int userId = 1;
	private final int bannedValue = 2;
	private String response = null;

	@Override
	public String execute(String request) throws ControllerException {
		String[] requestData = request.split(SPLITTER);

		try {
			ServiceFactory factory = ServiceFactory.getInstance();
			IClientService clientService = factory.getClientService();

			clientService.setUserBanned(requestData[userId], requestData[bannedValue]);
			
			response = "User is updated successfully";
		} catch (ServiceException e) {
			response = "Unable ban/unban user";
			System.out.println("log: " + e.getMessage());
		}

		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}

}
