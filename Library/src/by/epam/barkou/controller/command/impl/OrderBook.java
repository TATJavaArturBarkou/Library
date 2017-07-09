package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.Order;
import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.service.IOrderService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class OrderBook extends Command {

	private final int ACCESS_LEVEL = 1;
	private final int BOOK_ID = 1;
	
	private final int FIRST_USER = 0;
	private String response = null;

	@Override
	public String execute(String request) {

		String[] requestData = request.split(SPLITTER);

		Order order = new Order(Controller.authorized_users.get(FIRST_USER).getId(), requestData[BOOK_ID]);

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
		return this.ACCESS_LEVEL;
	}

}
