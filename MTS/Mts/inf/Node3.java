package Mts.inf;

import Mts.impl.SwiftMessage;

public interface Node3  extends FooBarInfo{

	/**
	 * Method that checks the currency code of a transaction/SwiftMessage against a list of blacklisted
	 * countries in a db table - 'BlacklistedCurrencies' - and based on this, routes the transaction to the
	 * appropriate table, either 'SafeTransactions' or 'SuspectTransactions' and returns a boolean.
	 * Should return true if fraudulent. Note: Your code should account for a Blacklist that would change over time.
	 *
	 * @param swiftMessage
	 * @return boolean
	 */
    public boolean fraudDetection(SwiftMessage swiftMessage);

}
