package by.epam.barkou.service.impl;

import by.epam.barkou.bean.Book;
import by.epam.barkou.dao.IBookDAO;
import by.epam.barkou.dao.exception.DAOException;
import by.epam.barkou.dao.factory.DAOFactory;
import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.exception.ServiceException;

public class LibraryServiceImpl implements ILibraryService {
	DAOFactory daoObjectFactory = DAOFactory.getInstance();
	IBookDAO bookDAO = daoObjectFactory.getBookDAO();
	boolean response;
	
	@Override
	public void addNewBook(Book book) throws ServiceException {

		// check parameters, e.g. length, special symbols

		if (book == null || book.getName().isEmpty()) {
			throw new ServiceException("Incorrect book data");
		}
		try {
			bookDAO.addBook(book);
			
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	
	}

	@Override
	public void updateBook(Book book) throws ServiceException {
		// check parameters, e.g. length, special symbols
		if (book == null || book.getName().isEmpty()) {
			throw new ServiceException("Incorrect book data");
		}
		try {
			bookDAO.updateBook(book);
			
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
