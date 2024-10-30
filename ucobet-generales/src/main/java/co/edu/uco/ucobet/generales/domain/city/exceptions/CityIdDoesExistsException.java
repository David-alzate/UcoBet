package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.data.CodigoMensaje;

public class CityIdDoesExistsException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	private CityIdDoesExistsException(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final CityIdDoesExistsException create() {
		var userMessage = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000011);
		return new CityIdDoesExistsException(userMessage);
	}

}
