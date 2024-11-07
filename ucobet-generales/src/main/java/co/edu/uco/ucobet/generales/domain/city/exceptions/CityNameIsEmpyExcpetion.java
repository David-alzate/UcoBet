package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class CityNameIsEmpyExcpetion extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityNameIsEmpyExcpetion(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityNameIsEmpyExcpetion create() {
		var userMessage = MessageHelper.getInstance().getMessage("M00021");
		return new CityNameIsEmpyExcpetion(userMessage);
	}

}
