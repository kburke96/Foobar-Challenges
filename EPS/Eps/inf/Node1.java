package Eps.inf;

import Eps.impl.EpasMessage;
import Eps.impl.EpasPayment;
import Eps.inf.FooBarInfo;

public interface Node1 extends FooBarInfo{
    
    public EpasPayment parseMessage(EpasMessage epasMessage);

}
