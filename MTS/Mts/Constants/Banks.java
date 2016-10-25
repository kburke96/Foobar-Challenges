package Mts.Constants;

import Mts.impl.banks.Bank;
import Mts.impl.banks.*;

public enum Banks {
    
    COCC(new COCC()),
    AMOCO(new AMOCO()),
    DBS(new DBS());
    
    private final Bank value;
    
    Banks(Bank s)
    {
        this.value = s;
    }
    
    public Bank value(){return value;}

}
