
package Mts.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import Builders.SwiftMessageBuilder;
import Mts.Exceptions.TeamNameNotDefinedException;
import Mts.Helper.DBConnector;
import Mts.inf.Node6;

/**
 * An example of how the student may implement the Node6 interface.
 * Not to be given to students on the day.
 * @author costellode
 *
 */
public class Node6Impl implements Node6 {

    public static void main(String[] args) {
       Node6Impl test = new Node6Impl();
       SwiftMessage swiftMessage = SwiftMessageBuilder.getNode6BadSendersReferenceTestMessage1();
       SwiftPayment swiftPayment = test.repair(swiftMessage);

       System.out.println(swiftPayment.getSendersReferenceCode());
       System.out.println(swiftPayment.getBankOpenationCode());
       System.out.println(swiftPayment.getDateCurencyAmount());
       System.out.println(swiftPayment.getOderingCustomer());
       System.out.println(swiftPayment.getBeneficiaryCustomer());
       System.out.println(swiftPayment.getDetailsOfCharges());
    }

    @Override
    public SwiftPayment repair(SwiftMessage swiftMessage) {

        //Determine whether the message needs to be repaired by checking with regex
        //Are these correct for Swift?
        String pattern1 = "[A-Za-z\\d]{16}";
        String pattern2 = "[A-Za-z]{4}";
        String pattern3 = "[\\d]{6}[A-Za-z]{3}[\\d\\W]{1,15}";
        String pattern4 = "[A-Za-z\\s]{1,56}";
        String pattern5 = "[\\w\\s\\W]{1,56}";   //Should we make this regex (ben field) same regex as ordering cust field (pattern4)?
        String pattern6 = "[A-Za-z]{3}";

        boolean sendersRefCodeNeedsRepair = false;
        boolean bankOperationCodeNeedsRepair = false;
        boolean dateCurrencyAmountNeedsRepair = false;
        boolean orderingCustomerNeedsRepair = false;
        boolean beneficiaryCustomerNeedsRepair = false;
        boolean detailsOfChargeNeedsRepair = false;

        SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
        String messageId = swiftPayment.getMessageId();

        if(!swiftPayment.getSendersReferenceCode().matches(pattern1)){
            sendersRefCodeNeedsRepair = true;
        }
        if(!swiftPayment.getBankOpenationCode().matches(pattern2)){
            bankOperationCodeNeedsRepair = true;
        }
        if(!swiftPayment.getDateCurencyAmount().matches(pattern3)){
            dateCurrencyAmountNeedsRepair = true;
        }
        if(!swiftPayment.getOderingCustomer().matches(pattern4)){
            orderingCustomerNeedsRepair = true;
        }
        if(!swiftPayment.getBeneficiaryCustomer().matches(pattern5)){
            beneficiaryCustomerNeedsRepair = true;
        }
        if(!swiftPayment.getDetailsOfCharges().matches(pattern6)){
            detailsOfChargeNeedsRepair = true;
        }

        //just used for debugging
//        System.out.println(sendersRefCodeNeedsRepair);
//        System.out.println(bankOperationCodeNeedsRepair);
//        System.out.println(dateCurrencyAmountNeedsRepair);
//        System.out.println(orderingCustomerNeedsRepair);
//        System.out.println(beneficiaryCustomerNeedsRepair);
//        System.out.println(detailsOfChargeNeedsRepair);
//        System.out.println();

        if (sendersRefCodeNeedsRepair || bankOperationCodeNeedsRepair
                || dateCurrencyAmountNeedsRepair || orderingCustomerNeedsRepair
                || beneficiaryCustomerNeedsRepair || detailsOfChargeNeedsRepair) {

            //At this point we know the SwiftMessage needs repair for some reason e.g. missing mandatory field, incorrect a/c number format etc.
            //Search the db for the message using its MessageID

            //We will provide the db details. They can write their own connection code if they want or just use the provided db helper class.
            String dbUrl = "jdbc:mysql://localhost:3306/Foobar";
            String dbUsername = "root";
            String dbPassword = "";

            //Call one of the db connection helper methods
            String query = "SELECT * FROM Messages WHERE MessageID='" + messageId + "'";
            ResultSet rs = DBConnector.queryTheDb(query, dbUrl, dbUsername, dbPassword);

//            Connection conn = DBConnector2.getConnection();
//            ResultSet rs = DBConnector2.queryTheDb(query, conn);

            try {
                while(rs.next()){
                    //Set the correct values based on info from the db
                    swiftPayment.setSendersReferenceCode(rs.getString("SendersReferenceCode"));
                    swiftPayment.setBankOpenationCode(rs.getString("BankOperationCode"));
                    swiftPayment.setDateCurencyAmount(rs.getString("DateCurrencyAmount"));
                    swiftPayment.setOderingCustomer(rs.getString("OrderingCustomer"));
                    swiftPayment.setBeneficiaryCustomer(rs.getString("BeneficiaryCustomer"));
                    swiftPayment.setDetailsOfCharges(rs.getString("DetailsOfCharges"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

//            DBConnector2.closeConnection(conn);
        }

        // Ideally should we would return a SwiftMessage?
        return swiftPayment;
    }

    @Override
    public String getTeamName() throws TeamNameNotDefinedException {
        return "some team name";
    }

}
