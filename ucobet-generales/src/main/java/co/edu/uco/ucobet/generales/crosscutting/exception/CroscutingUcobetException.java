package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class CroscutingUcobetException extends UcobetException{

	private static final long serialVersionUID = 1L;

	public CroscutingUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.CROSSCUTING);
	}
	
	public static final CroscutingUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new CroscutingUcobetException(userMessage, technicalMessage, rootException);
	}
	
	public static final CroscutingUcobetException create(final String userMessage) {
		return new CroscutingUcobetException(userMessage, userMessage, new Exception());
	}
	
	public static final CroscutingUcobetException create(final String userMessage, final String technicalMessage) {
		return new CroscutingUcobetException(userMessage, technicalMessage, new Exception());
	}

}
	