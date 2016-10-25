package Eps.inf;

public interface EpasPaymentInf {

    public String getPAN();

    public void setPAN(String PAN);

    public int getExpiryDate();

    public void setExpiryDate(int expiryDate);

    public int getEffectiveDate();

    public void setEffectiveDate(int effectiveDate);

    public int getAmt();

    public void setAmt(int amt);

    public String getCurCodeAlpha();

    public void setCurCodeAlpha(String curCodeAlpha);

    public String getTxnType();

    public void setTxnType(String txnType);

	public String getEncryptedPayload();

	public void setEncryptedPayload(String encryptedPayload);
	

	public void setRawMessage(String rawMessage);
	
	public String getRawMessage();
	

	public void setMACToVerify(String macToVerify);
	
	public String getMACToVerify();
	

	public void setMACSecretKey(byte[] macSecretKey);
	
	public byte[] getMACSecretKey();
	

	public String getMAC();

	public void setMAC(String mac);
	
	
	public String getPIN();

	public void setPIN(String pin);
}
