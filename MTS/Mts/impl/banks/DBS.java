package Mts.impl.banks;

import java.util.ArrayList;

import Mts.Constants.BankNames;
import Mts.Constants.Banks;
import Mts.Constants.Curs;

public class DBS extends Bank {
    
    public DBS()
    {
        super.setBankName("DBS");
        super.setBaseCur(Curs.USD.value());
        
        
    }

	@Override
	public void linkBanks() {
		ArrayList<Bank> tempBanks = new ArrayList<Bank>();
        tempBanks.add(amoco);
        tempBanks.add(cocc);
        
        super.setTrustedBanks(tempBanks);
		
	}

}
