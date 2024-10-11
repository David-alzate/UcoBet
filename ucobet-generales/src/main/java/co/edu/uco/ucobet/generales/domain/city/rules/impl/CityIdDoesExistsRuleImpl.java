package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.apication.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesNotExistsExcption;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesExistsRule;

public final class CityIdDoesExistsRuleImpl implements CityIdDoesExistsRule {

	private CityRepository cityRepository;

	public CityIdDoesExistsRuleImpl(final CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public void validate(final UUID data) {
		if (!cityRepository.existsById(data)) {
			throw CityIdDoesNotExistsExcption.create();
		}
	}

}