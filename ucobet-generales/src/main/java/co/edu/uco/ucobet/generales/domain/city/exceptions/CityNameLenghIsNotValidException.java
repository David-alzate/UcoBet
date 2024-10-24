package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityNameLenghIsNotValidException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityNameLenghIsNotValidException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityNameLenghIsNotValidException create() {
		var userMessage = "El tamaño para el nombre de la ciudad no es valido";
		return new CityNameLenghIsNotValidException(userMessage);
	}

}
