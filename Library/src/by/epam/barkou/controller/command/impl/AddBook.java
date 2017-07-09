package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.Book;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class AddBook extends Command {

	private final int ACCESS_LEVEL = 2;
	private final int BOOK_NAME = 1;
	private String response = null;
	
	@Override
	public String execute(String request) {

		String[] requestData = request.split(SPLITTER);
		Book book = new Book(requestData[BOOK_NAME]);
		ServiceFactory factory = ServiceFactory.getInstance();
		ILibraryService libraryService = factory.getLibraryService();

		try {

			libraryService.addNewBook(book);
			response = "Book has been added";

		} catch (ServiceException e) {
			response = "Unable to add book";
			System.out.println("log: " + e.getMessage());
	
		}
		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.ACCESS_LEVEL;
	}

}
