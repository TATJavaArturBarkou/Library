package by.epam.barkou.service;

import by.epam.barkou.bean.Book;
import by.epam.barkou.service.exception.ServiceException;

public interface ILibraryService {
	void addNewBook(Book book) throws ServiceException;

	void updateBook(Book book) throws ServiceException;
}
