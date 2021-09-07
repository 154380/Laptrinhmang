package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public abstract class IGeneralDAO<T> {
	Statement statement;
	PreparedStatement preStatement;
	Connection con;
	ResultSet rs;

	public abstract T[] selectAll();
	public abstract int insert(T object);
	public abstract int update(T object);
        public abstract int delete(T object);
	public abstract void closeConnection();
}
