package co.edu.uco.ucobet.generales.apication.usecase.city.impl;

import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

public final class RegisterNewCityRulesValidatorImpl implements RegisterNewCityRulesValidator {

	private RegisterNewCityIdRulesValidator cityIdRulesValidator;
	private RegisterNewCityNameRulesValidator cityNameRulesValidator;
	private RegisterNewCityStateRulesValidator cityStateRulesValidator;

	public RegisterNewCityRulesValidatorImpl(RegisterNewCityIdRulesValidator cityIdRulesValidator,
			RegisterNewCityNameRulesValidator cityNameRulesValidator,
			RegisterNewCityStateRulesValidator cityStateRulesValidator) {
		super();
		this.cityIdRulesValidator = cityIdRulesValidator;
		this.cityNameRulesValidator = cityNameRulesValidator;
		this.cityStateRulesValidator = cityStateRulesValidator;
	}

	@Override
	public void validate(final CityDomain data) {
		cityIdRulesValidator.validate(data);
		cityNameRulesValidator.validate(data);
	}

}
