package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.data.CodigoMensaje;

public class CityNameIsEmpyExcpetion extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityNameIsEmpyExcpetion(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityNameIsEmpyExcpetion create() {
		var userMessage = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000017);
		return new CityNameIsEmpyExcpetion(userMessage);
	}

}
