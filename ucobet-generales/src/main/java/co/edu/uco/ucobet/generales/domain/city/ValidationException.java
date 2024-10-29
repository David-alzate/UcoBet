package co.edu.uco.ucobet.generales.domain.city;

public class ValidationException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public ValidationException(final String userMessage) {
        super(userMessage);
    }
    
    public String getUserMessage() {
        return super.getMessage();
    }
}
