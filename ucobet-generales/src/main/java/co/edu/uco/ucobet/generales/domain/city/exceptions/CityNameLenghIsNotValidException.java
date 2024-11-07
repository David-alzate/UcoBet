package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class CityNameLenghIsNotValidException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityNameLenghIsNotValidException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityNameLenghIsNotValidException create() {
		var userMessage = MessageHelper.getInstance().getMessage("M00023");
		return new CityNameLenghIsNotValidException(userMessage);
	}

}
