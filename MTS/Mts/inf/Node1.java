package Mts.inf;

import Mts.impl.SwiftAccountHolder;
import Mts.impl.SwiftMessage;
import Mts.impl.SwiftPayment;

public interface Node1 extends FooBarInfo{
    
    public SwiftPayment parseMessage(SwiftMessage swiftMessage);

}
