package by.epam.barkou.controller.command.impl;

import java.util.Arrays;

import by.epam.barkou.bean.Book;
import by.epam.barkou.controller.command.Command;

import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class AddBook implements Command {

	@Override
	public String execute(String request) {

		String[] requestData = request.split("&");

		
		Book book = new Book(requestData[1]);

		String response = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		ILibraryService libraryService = factory.getLibraryService();

		try {
			
		libraryService.addNewBook(book);
		} catch (ServiceException e) {
			response = "Error during login procedure";
		}

		System.out.println("AddBook is executing");

		// response of all operation
		return response;
	}

}
