package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.Book;
import by.epam.barkou.controller.command.Command;

import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class UpdateBook extends Command {

	private String response = null;
	private final int BOOK_ID = 1;
	private final int BOOK_NAME = 2;
	private final int BOOK_AVAILABILITY = 3;
	private final int ACCESS_LEVEL = 2;

	@Override
	public String execute(String request) {

		String[] requestData = request.split(SPLITTER);

		Book book = new Book(requestData[BOOK_ID], requestData[BOOK_NAME], requestData[BOOK_AVAILABILITY]);
		ServiceFactory factory = ServiceFactory.getInstance();
		ILibraryService libraryService = factory.getLibraryService();

		try {

			libraryService.updateBook(book);
		} catch (ServiceException e) {
			response = "Unable to update book";
			System.out.println("log: " + e.getMessage());
		}

		return response;
	}

	@Override
	public int getAccessLevel() {

		return this.ACCESS_LEVEL;
	}

}
