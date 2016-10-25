package Eps.impl;

import Eps.inf.Node2;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import Eps.Exceptions.TeamNameNotDefinedException;

public class Node2Impl implements Node2 {

//	public static void main(String[] args) {
//		JUnitCore core = new JUnitCore();
//		core.run(Node2Test.class);
//	}

	@Override
	public String getTeamName() throws TeamNameNotDefinedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EpasPayment encryptMessage(EpasMessage epasMessage) {
		// Initialise EpasPayment object to return when all relevant attributes are set
		EpasPayment txn = new EpasPayment();

		// Initialise all data required for decryption
        String initVector = "7489416514321542";
        String key = "8725635645454857";
        String valueHex = epasMessage.getMessage();
		
		try {            
            // convert value from hex string to byte array
            int l = valueHex.length();
            byte[] value = new byte[l/2];
            for (int i = 0; i < l; i += 2) {
                value[i / 2] = (byte) ((Character.digit(valueHex.charAt(i), 16) << 4) + Character.digit(valueHex.charAt(i+1), 16));
            }
            
            // Generate suitable initialisation vector and key from the raw strings
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			// Initialise cipher object with correct encryption method and carry out decryption on data
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(value);
            
            // Set relevant attribute in EPAS payment object to return
            txn.setRawMessage(new String(original));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return txn;
	}
}
