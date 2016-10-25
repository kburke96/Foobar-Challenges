package Eps.impl;

public class EpasMessage{
    
    private String message;

    public String getMessage() {
        return message;
    }

    public EpasMessage(String message) {
        this.message = message;
    }

	public EpasMessage(EpasMessage message) {
		this.message = message.getMessage();
	}

}
