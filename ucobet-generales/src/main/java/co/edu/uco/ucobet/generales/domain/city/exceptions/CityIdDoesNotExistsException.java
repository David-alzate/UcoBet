package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.data.CodigoMensaje;

public class CityIdDoesNotExistsException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityIdDoesNotExistsException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityIdDoesNotExistsException create() {
		var userMessage = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000012);
		return new CityIdDoesNotExistsException(userMessage);
	}

}
