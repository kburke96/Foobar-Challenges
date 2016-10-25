package Mts.impl;

import java.util.ArrayList;

import Mts.inf.SwiftInf;
import Mts.inf.SwiftPaymentInf;



/**
 * An example of how the student may impl the swift interface
 * Not to be given to students on the day
 * @author quinnan
 *
 */
public class SwiftImpl implements SwiftInf{

    @Override
    public String getSendersReferenceCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SwiftAccountHolder enrich(SwiftMessage swiftMessage) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getAccNumber(int accNum) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getAddress(int accNum) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean fraudDetection(SwiftPaymentInf swiftPayment) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArrayList<String> routing(String s) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double conversion(double amount, String from, String to) {
    	// TODO Auto-generated method stub
        return 0;
    }

    @Override
    public SwiftPayment repair(SwiftMessage swiftMessage) {
        // TODO Auto-generated method stub
        SwiftMessage aSwiftMessage = new SwiftMessage("aMessage");
        SwiftPayment swiftPayment = new SwiftPayment(aSwiftMessage);
        return swiftPayment;
    }

}
