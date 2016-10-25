package Mts.inf;

public interface SwiftPaymentInf {

    public String getMessageId();

    public void setMessageId(String messageId);

    public String getSendersReferenceCode();

    public void setSendersReferenceCode(String sendersReferenceCode);

    public String getBankOpenationCode();

    public void setBankOpenationCode(String bankOpenationCode);

    public String getDateCurencyAmount();

    public void setDateCurencyAmount(String dateCurencyAmount);

    public String getOderingCustomer();

    public void setOderingCustomer(String oderingCustomer);

    public String getBeneficiaryCustomer();

    public void setBeneficiaryCustomer(String beneficiaryCustomer);

    public String getDetailsOfCharges();

    public void setDetailsOfCharges(String detailsOfCharges);

}
