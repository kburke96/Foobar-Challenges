package Mts.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Alternative Database connector class.
 * Using this class, the connection can be closed after they query the database
 *
 * @author costellode
 *
 */
public class DBConnector2 {

    /**
     * Creates a database connection
     * @return connection
     */
    public static Connection getConnection() {
        String driver = "org.gjt.mm.mysql.Driver";
        String url = "jdbc:mysql://localhost:3306/Foobar";
        String username = "root";
        String password = "";
        Connection conn = null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Cant load database driver");
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Cant connect to database");
        }
        return conn;
    }

    /**
     * Use this method for non-modification queries ie. SELECT statements
     * @param String query
     * @param Connection
     * @return ResultSet
     */
    public static ResultSet queryTheDb(String query, Connection conn) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
        } catch (SQLException e1) {
            System.out.println("Error executing query");
            e1.printStackTrace();
        }
        return rs;
    }

    /**
     * Use this method for database modification queries e.g. INSERT, UPDATE, DELETE
     * @param String query
     * @param Connection
     * @return int
     */
    public static int modifyTheDb(String query, Connection conn) {
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            pstmt = conn.prepareStatement(query);
            result = pstmt.executeUpdate();
        } catch (SQLException e1) {
            System.out.println("Error executing query");
            e1.printStackTrace();
        }
        return result;
    }

    /**
     * Closes the database connection
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Couldnt close the connection");
            }
        }
    }

}
