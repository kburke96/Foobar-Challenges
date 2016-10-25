package Mts.inf;


public interface Node5  extends FooBarInfo{

	/**
	 * Converts an amount from one currency to another
	 * @param amount (double)
	 * @param from (String - 3 character currency code)
	 * @param to (String - 3 character currency code)
	 * @return double
	 */
    public double conversion(double amount, String from, String to);

}
