package Mts.test.Node3;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import Builders.SwiftMessageBuilder;
import Mts.impl.Node3Impl;

/**
 * Node3 ('fraud') test cases
 * @author costellode
 */
public class Node3FraudTest {

	//Delete all rows from the SafeTransactions and SuspectTransactions tables
    @Test
    public void cleanDbTables() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Foobar", "root", "");
			String query1 = "DELETE FROM SafeTransactions";
			String query2 = "DELETE FROM SuspectTransactions";
			Statement statement = conn.createStatement();
		    statement.addBatch(query1);
		    statement.addBatch(query2);
		    statement.executeBatch();
            statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }

	@Test
    public void test1() {
		Node3Impl test = new Node3Impl();
		assertEquals((test.fraudDetection(SwiftMessageBuilder.getTestMessage("SYP"))), true);
    }

	@Test
    public void test2() {
		Node3Impl test = new Node3Impl();
		assertEquals((test.fraudDetection(SwiftMessageBuilder.getTestMessage("IRR"))), true);
    }

	@Test
    public void test3() {
		Node3Impl test = new Node3Impl();
		assertEquals((test.fraudDetection(SwiftMessageBuilder.getTestMessage("AUD"))), false);
    }

	@Test
    public void test4() {
		Node3Impl test = new Node3Impl();
		assertEquals((test.fraudDetection(SwiftMessageBuilder.getTestMessage("EUR"))), false);
    }

	@Test
    public void test5() {
		Node3Impl test = new Node3Impl();
		assertEquals((test.fraudDetection(SwiftMessageBuilder.getTestMessage("YER"))), true);
    }

	//Check how many transactions are in the SafeTransactions table
	@Test
    public void checkSafeTable() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Foobar", "root", "");
			String query = "SELECT COUNT(*) FROM SafeTransactions";
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				assertEquals(rs.getInt(1), 2);
			}
			rs.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }

	//Check how many transactions are in the SuspectTransactions table
	@Test
    public void checkSuspectTable() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Foobar", "root", "");
			String query = "SELECT COUNT(*) FROM SuspectTransactions";
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				assertEquals(rs.getInt(1), 3);
			}
			rs.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}