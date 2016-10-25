package Eps.impl;

import Eps.inf.Node1;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Eps.Exceptions.TeamNameNotDefinedException;

public class Node1Impl implements Node1 {

//	public static void main(String[] args) {
//		JUnitCore core = new JUnitCore();
//		core.run(Node1Test.class);
//	}

	@Override
	public String getTeamName() throws TeamNameNotDefinedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EpasPayment parseMessage(EpasMessage epasMessage) {
		// Initialise EpasPayment object to return when all relevant attributes are set
		EpasPayment txn = new EpasPayment();

		// Get the DOM Builder Factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// Get the DOM Builder
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Load and Parse the XML EPAS message (convert to InputStream for Document parsing)
		Document document = null;
		InputStream stream = new ByteArrayInputStream(epasMessage.getMessage().getBytes(StandardCharsets.UTF_8));
		try {
			document = builder.parse(stream);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Iterate through the nodes and set the data appropriately
		// in the EpasPayment object
		NodeList nodeList = document.getDocumentElement().getChildNodes();

	    // Identify the current node and set the value in the
		// appropriate attribute of the EpasPayment object
		for (int i = 0; i < nodeList.getLength(); i++) {
			if (nodeList.item(i) instanceof Element) {
				NodeList nodeListChild = nodeList.item(i).getChildNodes();
				
				for (int x = 0; x < nodeListChild.getLength(); x++) {
					Node childNode = nodeListChild.item(x);
					String content = childNode.getLastChild().getTextContent().trim();
					
					switch (childNode.getNodeName()) {
					case "PAN":
						txn.setPAN(content);
						break;
					case "ExpiryDate":
						txn.setExpiryDate(Integer.parseInt(content));
						break;
					case "EffectiveDate":
						txn.setEffectiveDate(Integer.parseInt(content));
						break;
					case "Amt":
						txn.setAmt(Integer.parseInt(content));
						break;
					case "CurCodeAlpha":
						txn.setCurCodeAlpha(content);
						break;
					case "Type":
						txn.setTxnType(content);
						break;
					}
				}
			}
		}
		return txn;
	}
}
