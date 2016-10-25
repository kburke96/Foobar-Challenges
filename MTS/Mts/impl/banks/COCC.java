package Mts.impl.banks;

import java.util.ArrayList;

import Mts.Constants.BankNames;
import Mts.Constants.Banks;
import Mts.Constants.Curs;

public class COCC extends Bank {
    
    public COCC()
    {
        super.setBankName("COCC");
        super.setBaseCur("USD");
        
        
    }

	@Override
	public void linkBanks() {
		ArrayList<Bank> temp = new ArrayList<Bank>();
        temp.add(dbs);
        
        super.setTrustedBanks(temp);
		
	}

}
