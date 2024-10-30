package co.edu.uco.ucobet.generales.domain.state.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.data.CodigoMensaje;

public class StateDoesNotExistsException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;

	private StateDoesNotExistsException(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final StateDoesNotExistsException create() {
		var userMessage = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000020);
		return new StateDoesNotExistsException(userMessage);
	}

}
