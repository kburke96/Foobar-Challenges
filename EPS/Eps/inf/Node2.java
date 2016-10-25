package Eps.inf;

import Eps.impl.EpasMessage;
import Eps.impl.EpasPayment;
import Eps.inf.FooBarInfo;

public interface Node2 extends FooBarInfo{
    
    public EpasPayment encryptMessage(EpasMessage epasMessage);

}
