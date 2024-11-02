package co.edu.uco.ucobet.generales.crosscutting.messagecatalog;

public interface MessageCatalog {
	
	String getMessage(String key);
    void addMessage(String key, String message);

}
