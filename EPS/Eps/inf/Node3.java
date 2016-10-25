package Eps.inf;

import Eps.impl.EpasMessage;
import Eps.impl.EpasPayment;
import Eps.inf.FooBarInfo;

public interface Node3 extends FooBarInfo{
    
    public EpasPayment generateMAC(EpasMessage epasMessage);

}
