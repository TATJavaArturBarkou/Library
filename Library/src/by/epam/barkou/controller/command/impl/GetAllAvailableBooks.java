package by.epam.barkou.controller.command.impl;

import java.util.ArrayList;

import by.epam.barkou.bean.Book;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class GetAllAvailableBooks extends Command {

	String response = null;
	public int accessLevel = 0;

	@Override
	public String execute(String request) {
		ArrayList<Book> bookList;
		ServiceFactory factory = ServiceFactory.getInstance();
		ILibraryService libraryService = factory.getLibraryService();
		StringBuilder responseBuilder = new StringBuilder();

		try {

			bookList = libraryService.getAllAvailableBooks();
			
			for(Book book:bookList){
				responseBuilder.append(book.getName());
				responseBuilder.append("&");
			}
			
			
		} catch (ServiceException e) {
			response = e.getMessage();
			System.out.println("log: " + e.getMessage());
			e.printStackTrace();
		}

		return responseBuilder.toString();
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
