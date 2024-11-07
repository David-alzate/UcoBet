package co.edu.uco.ucobet.generales.domain.state.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class StateDoesNotExistsException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;

	private StateDoesNotExistsException(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final StateDoesNotExistsException create() {
		var userMessage = MessageHelper.getInstance().getMessage("M00024");
		return new StateDoesNotExistsException(userMessage);
	}

}
