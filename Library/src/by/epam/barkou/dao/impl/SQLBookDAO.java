package by.epam.barkou.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import by.epam.barkou.bean.Book;
import by.epam.barkou.bean.User;
import by.epam.barkou.dao.IBookDAO;
import by.epam.barkou.dao.exception.DAOException;
import by.epam.barkou.dao.util.DBWorker;

public class SQLBookDAO implements IBookDAO {
	private DBWorker db = DBWorker.getInstance();
	Book book;

	@Override
	public void addBook(Book book) throws DAOException {
		this.book = book;

		String query;

		query = "INSERT INTO `books` (`name`) VALUES ('" + book.getName() + "')";

		Integer affected_rows = this.db.changeDBData(query);

		if (affected_rows > 0) {

		} else {
			throw new DAOException("Error while making sql operation");
		}

	}

	@Override
	public void updateBook(Book book) throws DAOException {
		this.book = book;

		Integer id_filtered = Integer.parseInt(book.getIdBook());
		String query = "";

		query = "UPDATE `books` SET `name` = '" + book.getName() + "', `availability` = '" + book.getAvailability()
				+ "' WHERE `id` = " + id_filtered;

		Integer affected_rows = this.db.changeDBData(query);

		if (affected_rows > 0) {
			//
		} else {
			throw new DAOException("Error while making sql operation");
		}

	}

	@Override
	public void deleteBook(long idBook) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Book book) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Book> getAllAvailableBooks() throws DAOException {
		String query;
		int availableBooks = 1;
		Book book;
		ArrayList<Book> booksList = new ArrayList<Book>();

		query = "SELECT * FROM `books` where availability='" + availableBooks + "';";

		try {

			ResultSet db_data = this.db.getDBData(query);
			while (db_data.next()) {

				book = new Book(db_data.getString("name"));
				booksList.add(book);
			}

			return booksList;

		} catch (NumberFormatException | SQLException e) {

			throw new DAOException("Error while making sql operation", e);
		}

	}

}
