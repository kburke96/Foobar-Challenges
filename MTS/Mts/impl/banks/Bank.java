package Mts.impl.banks;

import java.util.ArrayList;

public abstract class Bank {
	
	public static ArrayList<Bank> allBanks = new ArrayList<Bank>(); 
	
	public static AMOCO amoco = new AMOCO();
	public static COCC cocc = new COCC();
	public static DBS dbs = new DBS();
	
	public static void init()
	{
		allBanks.add(amoco);
		allBanks.add(cocc);
		allBanks.add(dbs);
		
		for(Bank bank : allBanks)
			bank.linkBanks();
	}
	
    private String bankName;
    
    private ArrayList<Bank> trustedBanks;
    
    private String baseCur;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public ArrayList<Bank> getTrustedBanks() {
        return trustedBanks;
    }

    public void setTrustedBanks(ArrayList<Bank> trustedBanks) {
        this.trustedBanks = trustedBanks;
    }

    public String getBaseCur() {
        return baseCur;
    }

    public void setBaseCur(String baseCur) {
        this.baseCur = baseCur;
    }
    
    public abstract void linkBanks();
    
    

}
