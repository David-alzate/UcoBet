package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class CityIdIsNullException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	private CityIdIsNullException(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final CityIdIsNullException create() {
		var userMessage = MessageHelper.getInstance().getMessage("M00017");
		return new CityIdIsNullException(userMessage);
	}

}
