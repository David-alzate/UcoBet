package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.apication.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityStateDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityStateDoesExistsRule;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

public class CityStateDoesExistsRuleImpl implements CityStateDoesExistsRule{
	
	private final StateRepository stateRepository;

    public CityStateDoesExistsRuleImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

	@Override
	public void validate(StateDomain data) {
		if(stateRepository.existsById(data.getId())) {
			throw CityStateDoesNotExistsException.create();
		}
		
	}

}
