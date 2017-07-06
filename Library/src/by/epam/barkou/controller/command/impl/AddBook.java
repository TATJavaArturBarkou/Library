package by.epam.barkou.controller.command.impl;

import java.util.Arrays;

import by.epam.barkou.bean.Book;
import by.epam.barkou.controller.command.Command;

import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class AddBook extends Command {

	public int accessLevel = 2;

	@Override
	public String execute(String request) {

		String[] requestData = request.split("&");

		Book book = new Book(requestData[1]);

		String response = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		ILibraryService libraryService = factory.getLibraryService();

		try {

			libraryService.addNewBook(book);
			response = "Book has been added";

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
