package Mts.test.Node2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Builders.SwiftMessageBuilder;
import Mts.impl.Node2Impl;


/**
 * Node2 ('enrich' method) test cases
 * @author costellode
 */
public class Node2EnrichTest {

	//Delete the contents of the AccountHolders table and insert a row for testing
//	@Test
//    public void cleanAndPopulateDbTable() {
//		try{
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Foobar", "root", "");
//			String query1 = "DELETE FROM AccountHolders";
//			String query2 = "INSERT INTO AccountHolders VALUES('ABC1234', 'John Doe', 25, 'Male')";
//			Statement statement = conn.createStatement();
//		    statement.addBatch(query1);
//		    statement.addBatch(query2);
//		    statement.executeBatch();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//    }

	@Test
    public void test1() {
		Node2Impl test = new Node2Impl();
		assertEquals(test.enrich(SwiftMessageBuilder.getMessage()).getName(), "John");
    }

	@Test
    public void test2() {
		Node2Impl test = new Node2Impl();
		assertEquals(test.enrich(SwiftMessageBuilder.getMessage()).getAge(), 25);
    }

	@Test
    public void test3() {
		Node2Impl test = new Node2Impl();
		assertTrue(test.enrich(SwiftMessageBuilder.getMessage()).getGender().equalsIgnoreCase("Male"));
    }

	//These will be added when we get the backend JSON/SQL functionality working

//	@Test
//    public void test4() {
//		Node2Impl test = new Node2Impl();
//		assertEquals(test.enrich(SwiftMessageBuilder.getNode6BadOrderingCustomerTestMessage2()).getName(), null);
//    }
//
//	@Test
//    public void test5() {
//		Node2Impl test = new Node2Impl();
//		assertEquals(test.enrich(SwiftMessageBuilder.getNode6BadOrderingCustomerTestMessage2()).getAge(), 0);
//    }
//
//	@Test
//    public void test6() {
//		Node2Impl test = new Node2Impl();
//		assertEquals(test.enrich(SwiftMessageBuilder.getNode6BadOrderingCustomerTestMessage2()).getName(), null);
//    }

}