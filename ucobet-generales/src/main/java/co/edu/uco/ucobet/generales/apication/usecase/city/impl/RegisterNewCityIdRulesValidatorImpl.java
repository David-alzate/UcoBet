package co.edu.uco.ucobet.generales.apication.usecase.city.impl;

import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistsRule;

public final class RegisterNewCityIdRulesValidatorImpl implements RegisterNewCityIdRulesValidator {

	private CityIdDoesNotExistsRule cityIdDoesNotExistsRule;

	public RegisterNewCityIdRulesValidatorImpl(CityIdDoesNotExistsRule cityIdDoesNotExistsRule) {
		super();
		this.cityIdDoesNotExistsRule = cityIdDoesNotExistsRule;
	}

	@Override
	public void validate(final CityDomain data) {
		data.generateId();
		try {
			cityIdDoesNotExistsRule.validate(data.getId());
		} catch (final CityIdDoesExistsException exception) {
			validate(data);
		}

	}

}
