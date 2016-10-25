package Eps.impl;

import Eps.inf.Node3;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import Eps.Exceptions.TeamNameNotDefinedException;

public class Node3Impl implements Node3 {

//	public static void main(String[] args) {
//		JUnitCore core = new JUnitCore();
//		core.run(Node3Test.class);
//	}

	@Override
	public String getTeamName() throws TeamNameNotDefinedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EpasPayment generateMAC(EpasMessage epasMessage) {
		// Initialise EpasPayment object to return when all relevant attributes are set
		EpasPayment txn = new EpasPayment();

		String value = epasMessage.getMessage();
		String key = "Challenge3Key";
		
		try {
            // Get an hmac_sha1 key from the raw key bytes
            byte[] keyBytes = key.getBytes();           
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA256");
            
            // Add secret key as byte array to EPAS payment object
            txn.setMACSecretKey(signingKey.getEncoded());
            
            // Get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            // Compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(value.getBytes());

            // Convert raw bytes to Hex
            char[] hexArray = "0123456789ABCDEF".toCharArray();
            char[] hexChars = new char[rawHmac.length * 2];
            for ( int j = 0; j < rawHmac.length; j++ ) {
                int v = rawHmac[j] & 0xFF;
                hexChars[j * 2] = hexArray[v >>> 4];
                hexChars[j * 2 + 1] = hexArray[v & 0x0F];
            }
            
            // Add resulting hex representation of MAC to EPAS payment object
            txn.setMAC(new String(hexChars));
            
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return txn;
	}
}
