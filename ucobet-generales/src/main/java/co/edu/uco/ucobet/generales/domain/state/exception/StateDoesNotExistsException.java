package co.edu.uco.ucobet.generales.domain.state.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class StateDoesNotExistsException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;

	private StateDoesNotExistsException(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final StateDoesNotExistsException create() {
		var userMessage = "El estado no existe existe.";
		return new StateDoesNotExistsException(userMessage);
	}

}
