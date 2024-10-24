package co.edu.uco.ucobet.generales.apication.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistsRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmpyRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLenghIsValidRule;

@Service
public final class RegisterNewCityNameRulesValidatorImpl implements RegisterNewCityNameRulesValidator {

	private CityNameLenghIsValidRule cityNameLenghIsValidRule;
	private CityNameFormatIsValidRule cityNameFormatIsValidRule;
	private CityNameIsNotEmpyRule cityNameIsNotEmpyRule;
	private CityNameIsNotNullRule cityNameIsNotNullRule;
	private CityNameForStateDoesNotExistsRule cityNameForStateDoesNotExistsRule;

	public RegisterNewCityNameRulesValidatorImpl(final CityNameLenghIsValidRule cityNameLenghIsValidRule,
			final CityNameFormatIsValidRule cityNameFormatIsValidRule,
			final CityNameIsNotEmpyRule cityNameIsNotEmpyRule, final CityNameIsNotNullRule cityNameIsNotNullRule,
			final CityNameForStateDoesNotExistsRule cityNameForStateDoesNotExistsRule) {
		this.cityNameLenghIsValidRule = cityNameLenghIsValidRule;
		this.cityNameFormatIsValidRule = cityNameFormatIsValidRule;
		this.cityNameIsNotEmpyRule = cityNameIsNotEmpyRule;
		this.cityNameIsNotNullRule = cityNameIsNotNullRule;
		this.cityNameForStateDoesNotExistsRule = cityNameForStateDoesNotExistsRule;
	}

	@Override
	public void validate(final CityDomain data) {
		cityNameLenghIsValidRule.validate(data.getName());
//		cityNameFormatIsValidRule.validate(data.getName());
		cityNameIsNotEmpyRule.validate(data.getName());
		cityNameIsNotNullRule.validate(data.getName());
		cityNameForStateDoesNotExistsRule.validate(data);

	}

}
