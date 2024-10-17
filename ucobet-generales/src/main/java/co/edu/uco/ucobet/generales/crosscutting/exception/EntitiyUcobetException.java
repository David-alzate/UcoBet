package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class EntitiyUcobetException extends UcobetException{

	private static final long serialVersionUID = 1L;

	public EntitiyUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.ENTITY);
	}
	
	public static final EntitiyUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new EntitiyUcobetException(userMessage, technicalMessage, rootException);
	}
	
	public static final EntitiyUcobetException create(final String userMessage) {
		return new EntitiyUcobetException(userMessage, userMessage, new Exception());
	}
	
	public static final EntitiyUcobetException create(final String userMessage, final String technicalMessage) {
		return new EntitiyUcobetException(userMessage, technicalMessage, new Exception());
	}

}
	