package Mts.inf;

import java.util.ArrayList;

import Mts.impl.SwiftAccountHolder;
import Mts.impl.SwiftMessage;
import Mts.impl.SwiftPayment;



public interface SwiftInf {

    /*
     *
     * Getters from the swift message to create a swift payment object
     *
     */

    public String getSendersReferenceCode();


    /**
     * Fill in the Swift account holder object with information from the database and earn points per items stored
     * @param accNum Account number to get info on
     * @return A swift account holder with all the information on the account
     */
    public SwiftAccountHolder enrich(SwiftMessage swiftMessage);

    /**
     * This will take in a payment and return the account number; Connect to database and find the info on the account number
     *
     * @param accNum The holders account number
     * @return <i>String</i> The <b><u>account number</u></b> of the account holder
     */
    public String getAccNumber(int accNum);

    /**
     * This will take in a account number and return the holders address
     *
     * @param accNum The account number
     * @return <i>String</i> The <b><u>address</u></b> of the account holder
     */
    public String getAddress(int accNum);


    /**
     * Check a message for fraud
     *
     * @param swiftPaymentType A swift message
     * @return <i>True</i> if any fraud is found
     */
    public boolean fraudDetection(SwiftPaymentInf swiftPayment);

    /**
     *
     * @param s
     * @return A list of routes in the format ["A/B","B/E","E/J"]
     */
    public ArrayList<String> routing(String s);

    /**
     * Convert from one currency to another
     *
     * @param amount
     * @param from
     * @param to
     * @return double
     */
    public double conversion(double amount, String from, String to);

    /**
     * Repair a transaction/message
     *
     * @param swiftMessage
     * @return swiftMessage
     */
    public SwiftPayment repair(SwiftMessage swiftMessage);

}
