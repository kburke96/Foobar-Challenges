package Eps.impl;

import Eps.inf.Node5;
import java.util.Arrays;

import Eps.Exceptions.TeamNameNotDefinedException;

public class Node5Impl implements Node5 {

//	public static void main(String[] args) {
//		JUnitCore core = new JUnitCore();
//		core.run(Node5Test.class);
//	}

	@Override
	public String getTeamName() throws TeamNameNotDefinedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EpasPayment decodePIN(EpasMessage epasMessage) {
		// Initialise EpasPayment object to return when all relevant attributes are set
		EpasPayment txn = new EpasPayment();

		// Extract PAN and PIN block from message
		String pan = epasMessage.getMessage().substring(epasMessage.getMessage().indexOf("<PAN>")+5, epasMessage.getMessage().indexOf("</PAN>"));
		String pinBlockHex = epasMessage.getMessage().substring(epasMessage.getMessage().indexOf("<PINBlock>")+10, epasMessage.getMessage().indexOf("</PINBlock>"));

        // convert PIN block from hex string to int array
		int[] pinBlockInt = new int[pinBlockHex.length() / 2];
		for (int i = 0; i < pinBlockHex.length(); i++) {
			String byteString = pinBlockHex.substring(i, ++i + 1);
			int hexOut = Integer.parseInt(byteString, 16);
			pinBlockInt[i / 2] = (hexOut & 0x000000ff);
		}

        // Pad the PAN with zeros and using the 12 right most digits, excluding the check digit (last digit in PAN)
		String panPadded = "0000" + pan.substring(1, 13);
		
		// convert padded PAN to int array
		int[] panPaddedInt = new int[panPadded.length() / 2];
		for (int i = 0; i < panPadded.length(); i++) {
			String byteString = panPadded.substring(i, ++i + 1);
			int hexOut = Integer.parseInt(byteString, 16);
			panPaddedInt[i / 2] = (hexOut & 0x000000ff);
		}
		
		// XOR PIN block int array and padded PAN int array to get the PIN
		byte[] pin = new byte[8];
		for (int cnt = 0; cnt < 8; cnt++) {
			pin[cnt] = (byte) (pinBlockInt[cnt] ^ panPaddedInt[cnt]);
		}
		
        // Convert raw bytes to Hex
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[pin.length * 2];
        for ( int j = 0; j < pin.length; j++ ) {
            int v = pin[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        
        
        // Add PIN as attribute to EPAS payment object
        txn.setPIN(new String(Arrays.copyOfRange(hexChars, 2, 6)));
		
		return txn;
	}
}
