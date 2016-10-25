package Eps.test;

import static org.junit.Assert.*;

import org.junit.Test;

import Builders.EpasMessageBuilder;
import Eps.impl.EpasMessage;
import Eps.impl.EpasPayment;
import Eps.impl.Node6Impl;

import org.junit.Rule;

public class Node6Test {
	Node6Impl ch6 = new Node6Impl();
	
	EpasPayment epasPayment = new EpasPayment();
	
	public Node6Test() {
		EpasMessage epasMessage = new EpasMessage(EpasMessageBuilder.getMessageCh4());
		
		epasPayment = ch6.decodePIN(epasMessage);
	}
	
	@Rule
	public CustomJUnitRule junitRule = new CustomJUnitRule();
	
	@Test
	public void testPIN() {
        assertTrue(epasPayment.getPIN() == "1234");
	}
}
