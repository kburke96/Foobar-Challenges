package Mts.impl;

import java.util.ArrayList;
import java.util.HashMap;

import Mts.Exceptions.FileNameInvalid;
import Mts.Helper.Filereader;
import Mts.inf.Node5;

/**
 * An example of how the student may implement the Node5 interface.
 * Not to be given to students on the day.
 * @author costellode
 *
 */
public class Node5Impl implements Node5 {

	public static void main(String[] args) {
		Node5Impl test = new Node5Impl();
		System.out.println(test.conversion(123.456, "EUR", "USD"));
	}

	@Override
	public double conversion(double amount, String from, String to) {
    	HashMap<String, String> currencyFiles = new HashMap<String, String>();
    	HashMap<String, Double> currencyRates = new HashMap<String, Double>();
    	String currencyRatesFileName = "CurrencyRatesFileList.txt";
    	String currencyCode = "";
    	String fileName = "";
    	double result = -1;
    	String pattern2 = "[A-Za-z]{3}";

    	if(!from.matches(pattern2) || !to.matches(pattern2)) {
    		System.out.println("'from' and 'to' must be 3 alphabetic characters each");
    		return -1;
    	}
    	else if(amount < 0) {
    		System.out.println("You cannot use negative numbers");
    		return -1;
    	}

        ArrayList<String> fileList = new ArrayList<String>();
		try {
			fileList = Filereader.readFromFile(currencyRatesFileName);
			for(String s : fileList) {
				String[] line = s.split(" ");
				currencyCode = line[0];
				fileName = line[1];
				currencyFiles.put(currencyCode, fileName);
			}
		} catch (FileNameInvalid e) {
			System.out.println("Error reading the currency filenames file");
		}

		String currencyFileToUse = currencyFiles.get(from);
		ArrayList<String> rateList = new ArrayList<String>();
		try {
			rateList = Filereader.readFromFile(currencyFileToUse);
		} catch (FileNameInvalid e) {
			System.out.println("Error reading the currency rates file");
		}
		for(String s : rateList) {
			currencyRates.put(s.split(" ")[0], Double.parseDouble(s.split(" ")[1]));
		}

	 	if(currencyRates.keySet().contains(to)) {
	 		result = Double.parseDouble(String.format("%.2f", amount * currencyRates.get(to)));
	 	}

    	return result;
	}

   @Override
    public String getTeamName() {
        return "some team name";
    }
}


