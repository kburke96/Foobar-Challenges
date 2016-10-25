package Mts.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import Builders.SwiftMessageBuilder;
import Mts.Exceptions.TeamNameNotDefinedException;
import Mts.inf.Node2;

import com.google.gson.Gson;

public class Node2Impl implements Node2{

	public static void main(String[] args) {
		Node2Impl test = new Node2Impl();
		SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
		SwiftAccountHolder accHolder = test.enrich(swiftMessage);
		String accountInfo = "\nAccount: " + accHolder.getAccountNum() + "\nName: " + accHolder.getName()
		                    + "\nAge: " + accHolder.getAge() + "\nGender: " + accHolder.getGender();
		System.out.println(accountInfo);
	}

	@Override
	public SwiftAccountHolder enrich(SwiftMessage swiftMessage) {

		// (1) Get the a/c number from the message
		SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
		String accountNum = swiftPayment.getOderingCustomer();

		// (2) Construct URL object with a/c number and send request
		String jsonString = "";
		try {
			//Example url for testing. We will need to have our own url that we can concatenate '?accNum=accountNum' onto
			URL url = new URL("http://query.yahooapis.com/v1/public/yql?q=select%20%2a%20from%20yahoo.finance.quotes%20WHERE%20symbol%3D%27WRC%27&format=json&diagnostics=true&env=store://datatables.org/alltableswithkeys&callback");
	        URLConnection conn = url.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	    // (3) Server uses a/c no. to do SQL query to get full a/c details.
	    //(4) The a/c details are placed in a JSON string and the server sends this response back to user.

	        while ((jsonString = in.readLine()) != null) {
	            System.out.println(jsonString);
	        }
	        in.close();
		} catch (Exception e){
			e.printStackTrace();
		}

		// (5) User parses the JSON string to a java object

		//Using dummy data here for now until we get the url sorted
		String dummyJsonString = "{\"accountNum\": \"GIAN ANGELO IMPORTSNAPLES\", \"name\": \"John\", \"age\": 25, \"gender\": \"male\"}";
		//String dummyJsonString = "{\"accountNum\": \"ABC123456\", \"name\": \"John\", \"age\": 25, \"gender\": \"male\"}";
		Gson gson = new Gson();

		//create the AccountHolder object which we will populate with data taken from the JSON response string from the server
		SwiftAccountHolder accHolder = gson.fromJson(dummyJsonString, SwiftAccountHolder.class);

		return accHolder;
	}

	@Override
	public String getTeamName() throws TeamNameNotDefinedException {
		return "some team name";
	}
}
