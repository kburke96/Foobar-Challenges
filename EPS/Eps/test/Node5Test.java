package Eps.test;

import static org.junit.Assert.*;

import org.junit.Test;

import Builders.EpasMessageBuilder;
import Eps.impl.EpasMessage;
import Eps.impl.EpasPayment;
import Eps.impl.Node5Impl;

import org.junit.Rule;

public class Node5Test {
	Node5Impl ch5 = new Node5Impl();
	
	EpasPayment epasPayment = new EpasPayment();
	
	public Node5Test() {
		EpasMessage epasMessage = new EpasMessage(EpasMessageBuilder.getMessageCh4());
		
		epasPayment = ch5.decodePIN(epasMessage);
	}
	
	@Rule
	public CustomJUnitRule junitRule = new CustomJUnitRule();
	
	@Test
	public void testPIN() {
        assertTrue(epasPayment.getPIN() == "1234");
	}
}
