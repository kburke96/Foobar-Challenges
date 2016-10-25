package Mts.test.Node1;

import static org.junit.Assert.*;

import org.junit.Test;

import Builders.SwiftMessageBuilder;
import Mts.impl.SwiftMessage;
import Mts.impl.SwiftPayment;
import Mts.inf.Node1;

public class Node1MandatoryFieldsTest{
    
    Node1 node1;

    @Test
    public void test() {
        SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
        SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
        
        System.out.println(swiftPayment.getBankOpenationCode());
        System.out.println(swiftPayment.getBeneficiaryCustomer());
        System.out.println(swiftPayment.getDateCurencyAmount());
        System.out.println(swiftPayment.getDetailsOfCharges());
        System.out.println(swiftPayment.getOderingCustomer());
        System.out.println(swiftPayment.getSendersReferenceCode());
        
        System.out.println(swiftPayment.getBasicHeader_1());
        System.out.println(swiftPayment.getApplicationHeaderInput_2());
        System.out.println(swiftPayment.getUserHeader_3());
        System.out.println(swiftPayment.getSwiftMessageBody_4());
        System.out.println(swiftPayment.getTrailer_5());
        
    }
    
    @Test
    public void testMandatoryfieldsSendersReferenceCodeNotNull()
    {
        SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
        SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
        
        assertNotNull(swiftPayment.getSendersReferenceCode());
    }
    
    
    @Test
    public void testMandatoryfieldsBankOpenationCodeNotNull()
    {
        SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
        SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
        
        assertNotNull(swiftPayment.getBankOpenationCode());
        
    }
    

    @Test
    public void testMandatoryfieldsDateCurencyAmountNotNull()
    {
        SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
        SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
        
        assertNotNull(swiftPayment.getDateCurencyAmount());
        
    }

    @Test
    public void testMandatoryfieldsOderingCustomerNotNull()
    {
        SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
        SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
        
        assertNotNull(swiftPayment.getOderingCustomer());
        
    }

    @Test
    public void testMandatoryfieldsBeneficiaryCustomerNotNull()
    {
        SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
        SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
        
        assertNotNull(swiftPayment.getBeneficiaryCustomer());
        
    }

    @Test
    public void testMandatoryfieldsDetailsOfChargesNotNull()
    {
        SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
        SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
        
        assertNotNull(swiftPayment.getDetailsOfCharges());
        
    }
    
    

}
