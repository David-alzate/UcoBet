package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class CityIsBeingUsedException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityIsBeingUsedException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityIsBeingUsedException create() {
		var userMessage = MessageHelper.getInstance().getMessage("M00019");
		return new CityIsBeingUsedException(userMessage);
	}

}
