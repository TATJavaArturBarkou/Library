package by.epam.barkou.dao.impl;

import by.epam.barkou.bean.Book;
import by.epam.barkou.dao.IBookDAO;
import by.epam.barkou.dao.exception.DAOException;
import by.epam.barkou.dao.util.DBWorker;

public class SQLBookDAO implements IBookDAO{
	private DBWorker db = DBWorker.getInstance();
	@Override
	public void addBook(Book book) throws DAOException{
		
	
			String query;

		
				query = "INSERT INTO `person` (`name`) VALUES ('" + book.getName() + "')";
			

			Integer affected_rows = this.db.changeDBData(query);

			// Если добавление прошло успешно...
			if (affected_rows > 0) {
			//
			} else {
			// throw exception
			}
		

	}

	@Override
	public void deleteBook(long idBook) throws DAOException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Book book) throws DAOException{
		// TODO Auto-generated method stub
		
	}

}
