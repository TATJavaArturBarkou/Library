package by.epam.barkou.controller.command.impl;


import by.epam.barkou.bean.Order;
import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.service.IOrderService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class OrderBook extends Command{

	public int accessLevel = 1;
	public int bookId = 1;

	@Override
	public String execute(String request) {

		String[] requestData = request.split("&");

		Order order = new Order(Controller.authorized_users.get(0).getId(),requestData[bookId]);

		String response = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		IOrderService iOrderService = factory.getIOrderService();

		try {

			iOrderService.orderBook(order);
			response = "Book has been ordered";

		} catch (ServiceException e) {
			response = e.getMessage();
			System.out.println("log: " + e.getMessage());
			e.printStackTrace();
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
