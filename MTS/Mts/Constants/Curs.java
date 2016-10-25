package Mts.Constants;

public enum Curs {
    USD("USD");
    
    private final String value;
    
    Curs(String s)
    {
        this.value = s;
    }
    
    public String value(){return value;}

}
