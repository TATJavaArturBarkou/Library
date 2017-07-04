package by.epam.barkou.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.epam.barkou.dao.exception.DAOException;

public class DBWorker {
	
	//  оличество р€дов таблицы, затронутых последним запросом.
	private Integer affected_rows = 0;
	
	// «начение автоинкрементируемого первичного ключа, полученное после
	// добавлени€ новой записи.
	private Integer last_insert_id = 0;

	private static DBWorker instance = null;

	public static DBWorker getInstance()
	{
		if (instance == null)
		{
			instance = new DBWorker();
		}
	
		return instance;
	}

	private DBWorker()
	{
			
	}
	
	// ¬ыполнение запросов на выборку данных.
	public ResultSet getDBData (String query)throws DAOException
	{
		Statement statement;
		Connection connect;
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection("jdbc:mysql://localhost/library?user=root&password=root&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci");
			statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			return resultSet;
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e)
		{
			throw new DAOException(e.getMessage(),e);
			
		}
		

	}
	
	// ¬ыполнение запросов на модификацию данных.
	public Integer changeDBData(String query)throws DAOException
	{
		Statement statement;
		Connection connect;
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection("jdbc:mysql://localhost/library?user=root&password=root&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci");
			statement = connect.createStatement();
			this.affected_rows = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		
			// ѕолучаем last_insert_id() дл€ операции вставки.
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()){
            	this.last_insert_id = rs.getInt(1);
            }
			
			return this.affected_rows;
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e)
		{
		
			throw new DAOException(e.getMessage(),e);
			
			
		}
	


	}

//---------------------------------------------------------------
	public Integer getAffectedRowsCount()
	{
		return this.affected_rows;
	}
	
	public Integer getLastInsertId()
	{
		return this.last_insert_id;
	}

}

