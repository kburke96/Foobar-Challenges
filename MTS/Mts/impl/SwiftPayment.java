package Mts.impl;

import java.util.ArrayList;

import Builders.SwiftMessageBuilder;
import Mts.inf.SwiftPaymentInf;


/**
 * Class for Swift payment PoJo. Bonus points for creating this from WSDL
 * Not to be given to students on the day
 * @author quinnan
 *
 */
public class SwiftPayment implements SwiftPaymentInf{

    /**
     * To be removed, only used in debugging
     * @param args
     */
    public static void main(String[] args)
    {

        SwiftMessage swiftMessage = SwiftMessageBuilder.getMessage();
        new SwiftPayment(swiftMessage);
    }

    /*
     * Headers
     */
    private String basicHeader_1;

    private String applicationHeaderInput_2;

    private String userHeader_3;

    private String swiftMessageBody_4;

    private String trailer_5;


    /*
     * Mandatory fields
     */
    private String messageId;

    private String sendersReferenceCode;

    private String bankOpenationCode;

    private String dateCurencyAmount;

    private String oderingCustomer;

    private String beneficiaryCustomer;

    private String detailsOfCharges;

    public String getBasicHeader_1() {
        return basicHeader_1;
    }

    public void setBasicHeader_1(String basicHeader_1) {
        this.basicHeader_1 = basicHeader_1;
    }

    public String getApplicationHeaderInput_2() {
        return applicationHeaderInput_2;
    }

    public void setApplicationHeaderInput_2(String applicationHeaderInput_2) {
        this.applicationHeaderInput_2 = applicationHeaderInput_2;
    }

    public String getUserHeader_3() {
        return userHeader_3;
    }

    public void setUserHeader_3(String userHeader_3) {
        this.userHeader_3 = userHeader_3;
    }

    public String getSwiftMessageBody_4() {
        return swiftMessageBody_4;
    }

    public void setSwiftMessageBody_4(String swiftMessageBody_4) {
        this.swiftMessageBody_4 = swiftMessageBody_4;
    }

    public String getTrailer_5() {
        return trailer_5;
    }

    public void setTrailer_5(String trailer_5) {
        this.trailer_5 = trailer_5;
    }



    public SwiftPayment(SwiftMessage swiftMessage)
    {
        //TODO Simple start:
        String message = swiftMessage.getMessage();
        ArrayList<String> parts = new ArrayList<String>();
        int startAt = 0;
        int counts = 0;

        for(int i = 0; i < message.length(); i++){

            if(message.charAt(i) == '{')
                counts++;
            if(message.charAt(i) == '}')
                counts --;

            if(message.charAt(i) == '{' && i != 0 && message.charAt(i - 1) == '}'){
                startAt = i;
            }
            else if(message.charAt(i) == '}' && startAt != -1 && counts == 0){
                parts.add(message.substring(startAt, i+1));
                startAt = -1;
            }
        }
        //TODO simple end

        basicHeader_1 = parts.get(0);
        applicationHeaderInput_2 = parts.get(1);
        userHeader_3 = parts.get(2);
        swiftMessageBody_4 = parts.get(3);
        if(parts.size() > 4)
            trailer_5 = parts.get(4);

        //System.out.println(basicHeader_1 + "\n" + applicationHeaderInput_2 + "\n" + userHeader_3 + "\n" + swiftMessageBody_4);
        breakDownSwiftMessageBody_4(swiftMessageBody_4);

    }

    /* (non-Javadoc)
     * @see Mts.impl.SwiftPaymentInf#getSendersReferenceCode()
     */
    @Override
    public String getSendersReferenceCode() {
        return sendersReferenceCode;
    }

    /* (non-Javadoc)
     * @see Mts.impl.SwiftPaymentInf#setSendersReferenceCode(java.lang.String)
     */
    @Override
    public void setSendersReferenceCode(String sendersReferenceCode) {
        this.sendersReferenceCode = sendersReferenceCode;
    }

    /* (non-Javadoc)
     * @see Mts.impl.SwiftPaymentInf#getBankOpenationCode()
     */
    @Override
    public String getBankOpenationCode() {
        return bankOpenationCode;
    }

    /* (non-Javadoc)
     * @see Mts.impl.SwiftPaymentInf#setBankOpenationCode(java.lang.String)
     */
    @Override
    public void setBankOpenationCode(String bankOpenationCode) {
        this.bankOpenationCode = bankOpenationCode;
    }

    /* (non-Javadoc)
     * @see Mts.impl.SwiftPaymentInf#getDateCurencyAmount()
     */
    @Override
    public String getDateCurencyAmount() {
        return dateCurencyAmount;
    }

    /* (non-Javadoc)
     * @see Mts.impl.SwiftPaymentInf#setDateCurencyAmount(java.lang.String)
     */
    @Override
    public void setDateCurencyAmount(String dateCurencyAmount) {
        this.dateCurencyAmount = dateCurencyAmount;
    }

    /* (non-Javadoc)
     * @see Mts.impl.SwiftPaymentInf#getOderingCustomer()
     */
    @Override
    public String getOderingCustomer() {
        return oderingCustomer;
    }

    /* (non-Javadoc)
     * @see Mts.impl.SwiftPaymentInf#setOderingCustomer(java.lang.String)
     */
    @Override
    public void setOderingCustomer(String oderingCustomer) {
        this.oderingCustomer = oderingCustomer;
    }

    /* (non-Javadoc)
     * @see Mts.impl.SwiftPaymentInf#getBeneficiaryCustomer()
     */
    @Override
    public String getBeneficiaryCustomer() {
        return beneficiaryCustomer;
    }

    /* (non-Javadoc)
     * @see Mts.impl.SwiftPaymentInf#setBeneficiaryCustomer(java.lang.String)
     */
    @Override
    public void setBeneficiaryCustomer(String beneficiaryCustomer) {
        this.beneficiaryCustomer = beneficiaryCustomer;
    }

    /* (non-Javadoc)
     * @see Mts.impl.SwiftPaymentInf#getDetailsOfCharges()
     */
    @Override
    public String getDetailsOfCharges() {
        return detailsOfCharges;
    }

    /* (non-Javadoc)
     * @see Mts.impl.SwiftPaymentInf#setDetailsOfCharges(java.lang.String)
     */
    @Override
    public void setDetailsOfCharges(String detailsOfCharges) {
        this.detailsOfCharges = detailsOfCharges;
    }

    /**
    *
    */
    @Override
    public String getMessageId() {
        return this.messageId;
    }

    @Override
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    // TODO Talk about what to give to hacker on the day
    private void breakDownSwiftMessageBody_4(String swiftMessageBody_4)
    {

        setMessageId(stripValeFromString(swiftMessageBody_4,"99:"));

        setSendersReferenceCode(stripValeFromString(swiftMessageBody_4,"20:"));

        setBankOpenationCode(stripValeFromString(swiftMessageBody_4,"23B:"));

        setDateCurencyAmount(stripValeFromString(swiftMessageBody_4,"32A:"));



        if(swiftMessageBody_4.indexOf("50A:") != -1)
        setOderingCustomer(stripValeFromString(swiftMessageBody_4,"50A:"));

        else if(swiftMessageBody_4.indexOf("50F:") != -1)
            setOderingCustomer(stripValeFromString(swiftMessageBody_4,"50F:"));

        else if(swiftMessageBody_4.indexOf("50K:") != -1)
            setOderingCustomer(stripValeFromString(swiftMessageBody_4,"50K:"));



        if(swiftMessageBody_4.indexOf("59A:") != -1)
            setBeneficiaryCustomer(stripValeFromString(swiftMessageBody_4,"59A:"));

            else if(swiftMessageBody_4.indexOf("59F:") != -1)
                setBeneficiaryCustomer(stripValeFromString(swiftMessageBody_4,"59F:"));

            else if(swiftMessageBody_4.indexOf("59:") != -1)
                setBeneficiaryCustomer(stripValeFromString(swiftMessageBody_4,"59:"));



        setDetailsOfCharges(stripValeFromString(swiftMessageBody_4,"71A:"));

    }

    private String stripValeFromString(String s, String key)
    {
        //TODO simple start
        String temp = s.substring(s.indexOf(key) + key.length());
        if(temp.indexOf(':') != -1)
            return temp.substring(0,temp.indexOf(':'));
        else
            return temp.substring(0,temp.length() - 1);
        //TODO simple end
    }


}