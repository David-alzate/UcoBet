package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class ControllerUcobetException extends UcobetException {

	private static final long serialVersionUID = 1L;

	public ControllerUcobetException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.CONTROLLER);
	}

	public static final ControllerUcobetException create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new ControllerUcobetException(userMessage, technicalMessage, rootException);
	}

	public static final ControllerUcobetException create(final String userMessage) {
		return new ControllerUcobetException(userMessage, userMessage, new Exception());
	}

	public static final ControllerUcobetException create(final String userMessage, final String technicalMessage) {
		return new ControllerUcobetException(userMessage, technicalMessage, new Exception());
	}

}
