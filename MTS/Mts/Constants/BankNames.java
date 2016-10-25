package Mts.Constants;


public enum BankNames{
    
    COCC("COCC"),
    AMOCO("AMOCO"),
    DBS("DBS");
    
    private final String value;
    
    BankNames(String s)
    {
        this.value = s;
    }
    
    public String value(){return value;}
}
