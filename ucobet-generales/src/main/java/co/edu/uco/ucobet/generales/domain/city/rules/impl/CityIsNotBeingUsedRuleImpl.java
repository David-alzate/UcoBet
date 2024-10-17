package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.apication.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIsBeingUsedException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIsNotBeingUsedRule;

public class CityIsNotBeingUsedRuleImpl implements CityIsNotBeingUsedRule{
	
	private CityRepository cityRepository;

	public CityIsNotBeingUsedRuleImpl(final CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public void validate(UUID data) {
		if(cityRepository.isCityBeingUsed(data)) {
			throw CityIsBeingUsedException.create();
		}
	}
}
