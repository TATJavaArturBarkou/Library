package by.epam.barkou.dao;

import by.epam.barkou.bean.Book;
import by.epam.barkou.dao.exception.DAOException;

public interface IBookDAO {
	void addBook(Book book) throws DAOException;

	void deleteBook(long idBook) throws DAOException;

	void delete(Book book) throws DAOException;
}
