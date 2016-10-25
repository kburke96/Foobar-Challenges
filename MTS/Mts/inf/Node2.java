package Mts.inf;

import Mts.impl.SwiftAccountHolder;
import Mts.impl.SwiftMessage;

public interface Node2 extends FooBarInfo{

	/**
	 * Populate SwiftAccountHolder object with customers data got from a JSON string
	 * @param accountNumber
	 * @return SwiftAccountHolder
	 */
    public SwiftAccountHolder enrich(SwiftMessage swiftMessage);

}
