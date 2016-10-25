package Eps.impl;

import Eps.inf.EpasPaymentInf;
import Eps.impl.EpasPayment;


/**
 * Sample class for EPAS payment object
 * @author quinnan
 *
 */
public class EpasPayment implements EpasPaymentInf{
    
    /*public static void main(String[] args)
    {
        EpasPayment epasPayment = new EpasPayment();
    }*/

    

    public EpasPayment()
    {

    }

    private String PAN;
    private int expiryDate;
    private int effectiveDate;
    
    private int amt;
    private String curCodeAlpha;
    private String txnType;
    
    private String encryptedPayload;
    
    String rawMessage;
    
    private String macToVerify;
    private byte[] macSecretKey;
    private String MAC;
    
    private String pin;
    
	@Override
	public String getPAN() {
		return PAN;
	}



	@Override
	public void setPAN(String PAN) {
		this.PAN = PAN;
	}



	@Override
	public int getExpiryDate() {
		return expiryDate;
	}



	@Override
	public void setExpiryDate(int expiryDate) {
		this.expiryDate = expiryDate;
	}



	@Override
	public int getEffectiveDate() {
		return effectiveDate;
	}



	@Override
	public void setEffectiveDate(int effectiveDate) {
		this.effectiveDate = effectiveDate;
	}



	@Override
	public int getAmt() {
		return amt;
	}



	@Override
	public void setAmt(int amt) {
		this.amt = amt;
	}



	@Override
	public String getCurCodeAlpha() {
		return curCodeAlpha;
	}



	@Override
	public void setCurCodeAlpha(String curCodeAlpha) {
		this.curCodeAlpha = curCodeAlpha;
	}



	@Override
	public String getTxnType() {
		return txnType;
	}



	@Override
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}


	@Override
	public String getEncryptedPayload() {
		return encryptedPayload;
	}

	@Override
	public void setEncryptedPayload(String encryptedPayload) {
		this.encryptedPayload = encryptedPayload;
	}

    
	
	
	
	@Override
	public String getRawMessage() {
		return rawMessage;
	}

	@Override
	public void setRawMessage(String rawMessage) {
		this.rawMessage = rawMessage;
	}
	
	
	
	

	@Override
	public String getMACToVerify() {
		return macToVerify;
	}

	@Override
	public void setMACToVerify(String macToVerify) {
		this.macToVerify = macToVerify;
	}
	

	@Override
	public byte[] getMACSecretKey() {
		return macSecretKey;
	}

	@Override
	public void setMACSecretKey(byte[] macSecretKey) {
		this.macSecretKey = macSecretKey;
	}
	

	@Override
	public String getMAC() {
		return MAC;
	}

	@Override
	public void setMAC(String mac) {
		this.MAC = mac;
	}
	

	
	@Override
	public String getPIN() {
		return pin;
	}

	@Override
	public void setPIN(String pin) {
		this.pin = pin;
	}
}