package co.edu.uco.ucobet.generales.apication.usecase.city.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistsRule;

public final class RegisterNewCityStateRulesValidatorImpl implements RegisterNewCityStateRulesValidator {

	private StateDoesExistsRule stateDoesExistsRule;

	public RegisterNewCityStateRulesValidatorImpl(StateDoesExistsRule stateDoesExistsRule) {
		super();
		this.stateDoesExistsRule = stateDoesExistsRule;
	}

	@Override
	public void validate(final CityDomain data) {
		validateState(data.getState().getId());

	}

	private void validateState(final UUID data) {
		stateDoesExistsRule.validate(data);

	}

}
