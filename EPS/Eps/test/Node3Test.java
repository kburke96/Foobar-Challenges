package Eps.test;

import static org.junit.Assert.*;

import org.junit.Test;

import Builders.EpasMessageBuilder;
import Eps.impl.EpasMessage;
import Eps.impl.EpasPayment;
import Eps.impl.Node3Impl;

import org.junit.Rule;

public class Node3Test {
	Node3Impl ch3 = new Node3Impl();
	
	EpasPayment epasPayment = new EpasPayment();
	
	public Node3Test() {
		EpasMessage epasMessage = new EpasMessage(EpasMessageBuilder.getMessageCh3());
		
		epasPayment = ch3.generateMAC(epasMessage);
	}
	
	@Rule
	public CustomJUnitRule junitRule = new CustomJUnitRule();

	
	@Test
	public void testMAC() {
		assertTrue ("F342FC9EA9F6691B1D1C0021C59902621AD4ECD038C9D052F066E03AD74D1642".equals(epasPayment.getMAC()));
	}

	@Test
	public void testMACSecretKey() {
		assertTrue (epasPayment.getMACSecretKey().toString().contains("50f8360d"));
	}
}
