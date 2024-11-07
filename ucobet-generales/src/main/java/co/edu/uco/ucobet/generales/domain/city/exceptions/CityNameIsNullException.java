package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class CityNameIsNullException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;
	
	private CityNameIsNullException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityNameIsNullException create() {
		var userMessage = MessageHelper.getInstance().getMessage("M00022");
		return new CityNameIsNullException(userMessage);
	}

}
