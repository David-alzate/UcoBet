package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityIdDoesNotExistsExcption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	public CityIdDoesNotExistsExcption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityIdDoesNotExistsExcption create() {
		var userMessage = "No existe la ciudad con el id indicado";
		return new CityIdDoesNotExistsExcption(userMessage);
	}

}
