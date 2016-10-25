package Mts.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class containing 2 helper methods for database access:
 * 'queryTheDb' - connects to a database, executes a query and returns a result set.
 * 'modifyTheDb' - connects to a database, executes a modification query and returns an integer.
 * @author costellode
 *
 */
public class DBConnector {

	/**
	 * Use this method for non-modification queries ie. SELECT statements
	 * @param query
	 * @param dbUrl
	 * @param username
	 * @param password
	 * @return ResultSet
	 */
	public static ResultSet queryTheDb(String query, String dbUrl, String username, String password) {
		//TODO how do we close the connection and return the ResultSet ?

		ResultSet rs = null;

		//ensure mysql jdbc connector jar is available, build path etc
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Cant load database driver");
		}

		//attempt to connect to the db
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, username, password);
		}
		catch (SQLException e){
			System.out.println("Cant connect to database");
		}
		//System.out.println("Connected to database");

		//Query the db
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			rs = statement.executeQuery();
		} catch (SQLException e1) {
			System.out.println("Error executing query");
			e1.printStackTrace();
		}

		//TODO Problem: if we close the connection, we cant return the result set. How do we close it? Pass in connection from calling method will work but may not want to do this?
//		try {
//			conn.close();
//		}
//		catch (SQLException e ) {
//			e.printStackTrace();
//		}
		return rs;
	}

	/**
	 * Use this method for database modification queries e.g. INSERT, UPDATE, DELETE
	 * @param query
	 * @param dbUrl
	 * @param username
	 * @param password
	 * @return int
	 */
	public static int modifyTheDb(String query, String dbUrl, String username, String password) {
		int result = 0;

		//ensure mysql jdbc connector jar is available, build path etc
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Cant load database driver");
		}

		//attempt to connect to the db
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, username, password);
		}
		catch (SQLException e){
			System.out.println("Cant connect to database");
		}
		//System.out.println("Connected to database");

		//Query the db
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			result = statement.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("Error executing query");
			e1.printStackTrace();
		}

		try {
		conn.close();
		}
		catch (SQLException e ) {
			e.printStackTrace();
			System.out.println("Couldnt close connection");
		}

		return result;
	}

}
