package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class CityNameForStateDoesExistsException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	private CityNameForStateDoesExistsException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static final CityNameForStateDoesExistsException create() {
		var userMessage = MessageHelper.getInstance().getMessage("M00020");
		return new CityNameForStateDoesExistsException(userMessage);
	}

}
