package Mts.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import Builders.SwiftMessageBuilder;
import Mts.Helper.DBConnector;
import Mts.inf.Node3;

/**
 * An example of how the student may implement the Node3 interface.
 * Not to be given to students on the day.
 * @author costellode
 *
 */
public class Node3Impl implements Node3 {

	public static void main(String[] args) {
		SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
		Node3Impl test = new Node3Impl();
		System.out.println(test.fraudDetection(swiftMessage));
	}

	@Override
	public boolean fraudDetection(SwiftMessage swiftMessage) {
		//Find the currency of the transaction
		SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
		String currency = swiftPayment.getDateCurencyAmount().substring(6,9);
		System.out.println(currency);

		boolean isFraudulent = true;

		//We will provide the db details so they can write their own connection code if they want. Otherwise they can just use the provided helper class
		String dbUrl = "jdbc:mysql://localhost:3306/Foobar";
		String dbUsername = "root";
		String dbPassword = "";

		//call one of the db connection helper methods to see if the currency is blacklisted.
		String query1 = "SELECT * FROM BlacklistedCurrencies WHERE CurrencyCode='" + currency + "'";
		ResultSet rs = DBConnector.queryTheDb(query1, dbUrl, dbUsername, dbPassword);
		try {
			if(rs.next()) {
				//The currency is on the blacklist so send it to SuspectTransactions table and set boolean to true
				try {
					String idQuery = "SELECT MAX(TransactionID) FROM SuspectTransactions";
					ResultSet resultSet = DBConnector.queryTheDb(idQuery, dbUrl, dbUsername, dbPassword);
					try {
						while(resultSet.next()){
							int maxId = resultSet.getInt(1);
							String query2 = "INSERT INTO SuspectTransactions (TransactionID, TransactionMessage) VALUES ('" + (++maxId) + "', 'Hello World')";
							DBConnector.modifyTheDb(query2, dbUrl, dbUsername, dbPassword);
							isFraudulent = true;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			else {
				//The currency is not on the blacklist so its ok to send it to SafeTransactions table and set boolean to false
				String idQuery = "SELECT MAX(TransactionID) FROM SafeTransactions";
				ResultSet resultSet = DBConnector.queryTheDb(idQuery, dbUrl, dbUsername, dbPassword);
				try{
					while(resultSet.next()){
						int maxId = resultSet.getInt(1);
						String query3 = "INSERT INTO SafeTransactions (TransactionID, TransactionMessage) VALUES ('" + (++maxId) + "', 'Hello World')";
						DBConnector.modifyTheDb(query3, dbUrl, dbUsername, dbPassword);
						isFraudulent = false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isFraudulent;
	}

	@Override
	public String getTeamName() {
		return "some team name";
	}

}
