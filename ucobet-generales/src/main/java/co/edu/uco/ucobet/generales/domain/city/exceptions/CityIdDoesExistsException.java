package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityIdDoesExistsException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityIdDoesExistsException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityIdDoesExistsException create() {
		var userMessage = "Ya existe una ciudad con este id";
		return new CityIdDoesExistsException(userMessage);
	}

}
