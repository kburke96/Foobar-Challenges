package Mts.Helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Mts.Exceptions.FileNameInvalid;

/**
 * This class provides one method - 'readFromFile' - that is used to read lines from a file.
 * @author costellode
 *
 */
public class Filereader {
	
	/**
	 * This static method takes a filename as a parameter and returns an ArrayList which contains
	 * the lines from the file specified.
	 * @param fileName
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> readFromFile(String fileName) throws FileNameInvalid {
		
		ArrayList<String> fileList = new ArrayList<String>();
		
		try {
			FileReader aFileReader = new FileReader(fileName);
			BufferedReader aBufferReader = new BufferedReader(aFileReader);
			String lineFromFile = aBufferReader.readLine();
			while(lineFromFile != null) {
				fileList.add(lineFromFile);
				lineFromFile = aBufferReader.readLine();
			}
			aBufferReader.close();
			aFileReader.close();
		}
		catch(IOException x) {
			System.out.println("Error reading file.");
		}
		
		return fileList;
	}
}
