package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class CityIdDoesNotExistsException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityIdDoesNotExistsException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityIdDoesNotExistsException create() {
		var userMessage = MessageHelper.getInstance().getMessage("M00016");
		return new CityIdDoesNotExistsException(userMessage);
	}

}
