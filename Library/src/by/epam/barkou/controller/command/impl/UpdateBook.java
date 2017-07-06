package by.epam.barkou.controller.command.impl;


import by.epam.barkou.bean.Book;
import by.epam.barkou.controller.command.Command;

import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class UpdateBook extends Command {

	String response = null;
	int bookId = 1;
	int bookName = 2;
	int bookAvailability = 3;
	public int accessLevel = 2;
	@Override
	public String execute(String request) {

		String[] requestData = request.split("&");

		
		Book book = new Book(requestData[bookId], requestData[bookName],requestData[bookAvailability]);
		ServiceFactory factory = ServiceFactory.getInstance();
		ILibraryService libraryService = factory.getLibraryService();

		try {
			
		libraryService.updateBook(book);
		} catch (ServiceException e) {
			response = e.getMessage();
			System.out.println("log: "+e.getMessage());
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
