package Eps.test;

import static org.junit.Assert.*;

import org.junit.Test;

import Builders.EpasMessageBuilder;
import Eps.impl.EpasMessage;
import Eps.impl.EpasPayment;
import Eps.impl.Node4Impl;

import org.junit.Rule;

public class Node4Test {
	Node4Impl ch4 = new Node4Impl();
	
	EpasPayment epasPayment = new EpasPayment();
	
	public Node4Test() {
		EpasMessage epasMessage = new EpasMessage(EpasMessageBuilder.getMessageCh4());
		
		epasPayment = ch4.decodePIN(epasMessage);
	}
	
	@Rule
	public CustomJUnitRule junitRule = new CustomJUnitRule();
	
	@Test
	public void testPIN() {
        assertTrue(epasPayment.getPIN() == "1234");
	}
}
