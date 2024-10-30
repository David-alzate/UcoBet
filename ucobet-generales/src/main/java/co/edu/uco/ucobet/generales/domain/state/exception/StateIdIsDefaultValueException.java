package co.edu.uco.ucobet.generales.domain.state.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.data.CodigoMensaje;

public class StateIdIsDefaultValueException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;

	private StateIdIsDefaultValueException(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final StateIdIsDefaultValueException create() {
		var userMessage = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000021);
		return new StateIdIsDefaultValueException(userMessage);
	}

}
