package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class InteractorUcobetException extends UcobetException {

	private static final long serialVersionUID = 1L;

	public InteractorUcobetException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.INTERACTOR);
	}

	public static final InteractorUcobetException create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new InteractorUcobetException(userMessage, technicalMessage, rootException);
	}

	public static final InteractorUcobetException create(final String userMessage) {
		return new InteractorUcobetException(userMessage, userMessage, new Exception());
	}

	public static final InteractorUcobetException create(final String userMessage, final String technicalMessage) {
		return new InteractorUcobetException(userMessage, technicalMessage, new Exception());
	}

}
