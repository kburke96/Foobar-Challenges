package Mts.impl.banks;

import java.util.ArrayList;

import Mts.Constants.BankNames;
import Mts.Constants.Banks;
import Mts.Constants.Curs;

public class AMOCO extends Bank {
    
    public AMOCO()
    {
        super.setBankName("AMOCO");
        super.setBaseCur("USD");
        
        
        
    }

	@Override
	public void linkBanks() {
		ArrayList<Bank> tempBankList = new ArrayList<Bank>();
        tempBankList.add(cocc);
        
        super.setTrustedBanks(tempBankList);
		
	}

}
