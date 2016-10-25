package Eps.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Builders.EpasMessageBuilder;
import Eps.impl.EpasMessage;
import Eps.impl.EpasPayment;
import Eps.impl.Node2Impl;

import org.junit.Rule;

public class Node2Test {
	Node2Impl ch2 = new Node2Impl();
	
	EpasPayment epasPayment = new EpasPayment();
	
	public Node2Test(){
		EpasMessage epasMessage = new EpasMessage(EpasMessageBuilder.getMessageCh2());
		
		epasPayment = ch2.encryptMessage(epasMessage);
	}
	

	@Rule
	public CustomJUnitRule junitRule = new CustomJUnitRule();

	
	@Test
	public void testDecrypt() {	    
	    String decrypt = "<Document><Card><PAN>43111234567890</PAN><ExpiryDate>1116</ExpiryDate><EffectiveDate>1114</EffectiveDate></Card><Txn><Amt>2000</Amt><CurCodeAlpha>USD</CurCodeAlpha><CurCodeNum>840</CurCodeNum><Type>PURC</Type></Txn></Document>";
	    
		assertTrue (decrypt.equals(epasPayment.getRawMessage()));
		
		//8A4D7326EDBF362704C9A18364D46D342C2F3C98DE9D82399637FAEBBB2B8D556171593B165A14C990490D1A23DBE357C56E33D2C31A3C8EF6E006A84863B36935FBBE6D967DCD73EF26EDB0AFDFF6EA2D75B90C51D35E047AC84BE2A53F7ACD04D320DEC6ADCB1955D4F722B76BE2B00392E408CA8FC5210554DEAAE42229B6A767B745EE671076474896EEAA0CB41905C1D5F2CBCEBFE2017CCA0AAC623F9DD041ED58FF55B19BD2A9805D86386F457DFA68A78E09092F15D2AAFD647D1E6D19F46A507A998A7ED3643603943732A1C782691C73E66449422411F7B8AA7D636BBAF40AAE44A57675D18F1A34671952
	}
}
