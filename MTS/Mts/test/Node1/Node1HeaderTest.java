package Mts.test.Node1;

import static org.junit.Assert.*;

import org.junit.Test;

import Builders.SwiftMessageBuilder;
import Mts.impl.SwiftMessage;
import Mts.impl.SwiftPayment;

public class Node1HeaderTest {

    @Test
    public void testHeader1NotNull() {
        SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
        SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
        
        assertNotNull(swiftPayment.getBasicHeader_1());
    }
    
    @Test
    public void testHeader2NotNull(){
        SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
        SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
        
        assertNotNull(swiftPayment.getApplicationHeaderInput_2());
    }
    
    @Test
    public void testHeader3NotNull(){
        SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
        SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
        
        assertNotNull(swiftPayment.getUserHeader_3());
    }
    

    @Test
    public void testHeader4NotNull(){
        SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
        SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
        
        assertNotNull(swiftPayment.getSwiftMessageBody_4());
    }



    @Test
    public void testHeader5NotNull(){
        SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
        SwiftPayment swiftPayment = new SwiftPayment(swiftMessage);
        
        assertNotNull(swiftPayment.getTrailer_5());
    }


}
