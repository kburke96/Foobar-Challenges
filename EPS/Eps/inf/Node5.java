package Eps.inf;

import Eps.impl.EpasMessage;
import Eps.impl.EpasPayment;
import Eps.inf.FooBarInfo;

public interface Node5 extends FooBarInfo{
    
    public EpasPayment decodePIN(EpasMessage epasMessage);

}
