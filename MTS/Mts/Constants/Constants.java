package Mts.Constants;

public enum Constants {

    FOOBARINFO ("FooBarInfo.java"),
    F("E");

    private final String value;
    
    Constants(String s) {
        this.value = s;
    }
    public String value() { return value; }

}
