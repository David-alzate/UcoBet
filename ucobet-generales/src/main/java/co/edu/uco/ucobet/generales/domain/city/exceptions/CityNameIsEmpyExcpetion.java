package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityNameIsEmpyExcpetion extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityNameIsEmpyExcpetion(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityNameIsEmpyExcpetion create() {
		var userMessage = "El nombre de la ciudad no puede ser vacio";
		return new CityNameIsEmpyExcpetion(userMessage);
	}

}
