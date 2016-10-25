package Eps.test;

import org.junit.Test;

import Builders.EpasMessageBuilder;
import Eps.impl.EpasMessage;
import Eps.impl.EpasPayment;
import Eps.impl.Node1Impl;

import static org.junit.Assert.assertTrue;
import org.junit.Rule;


public class Node1Test {
	Node1Impl ch1 = new Node1Impl();
	
	EpasPayment epasPayment = new EpasPayment();
	
	public Node1Test(){
		EpasMessage epasMessage = new EpasMessage(EpasMessageBuilder.getMessageCh1());
		
		epasPayment = ch1.parseMessage(epasMessage);
	}
	
	@Rule
	public CustomJUnitRule junitRule = new CustomJUnitRule();

	@Test
	public void testPAN() {
		assertTrue ("43111234567890".equals(epasPayment.getPAN()));
	}

	@Test
	public void testExpiryDate() {

		assertTrue (epasPayment.getExpiryDate() == 1116);
	}

	@Test
	public void testEffectiveDate() {

		assertTrue (epasPayment.getEffectiveDate() == 1114);
	}

	@Test
	public void testAmt() {

		assertTrue (epasPayment.getAmt() == 1000);
	}

	@Test
	public void testCurCodeAlpha() {
		assertTrue ("USD".equals(epasPayment.getCurCodeAlpha()));
	}

	@Test
	public void testTxnType() {

		assertTrue ("PURC".equals(epasPayment.getTxnType()));
	}

}
