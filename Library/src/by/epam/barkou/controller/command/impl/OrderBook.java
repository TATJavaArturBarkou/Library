package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.Order;
import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.service.IOrderService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class OrderBook extends Command {

	private final int accessLevel = 1;
	private final int bookId = 1;
	
	private final int firstUser = 0;
	private String response = null;

	@Override
	public String execute(String request) {

		String[] requestData = request.split(SPLITTER);
		String userId= Controller.authorized_users.get(firstUser).getId();
		Order order = new Order(userId, requestData[bookId]);

		ServiceFactory factory = ServiceFactory.getInstance();
		IOrderService iOrderService = factory.getIOrderService();

		try {

			iOrderService.orderBook(order);
			response = "Book has been ordered";

		} catch (ServiceException e) {
			response = "Unable to order book";
			System.out.println("log: " + e.getMessage());
		}
		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}

}
