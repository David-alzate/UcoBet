package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.apication.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityStateDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistsRule;

public class StateDoesExistsRuleImpl implements StateDoesExistsRule{
	
	private final StateRepository stateRepository;

    public StateDoesExistsRuleImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

	@Override
	public void validate(UUID data) {
		if(stateRepository.existsById(data)) {
			throw CityStateDoesNotExistsException.create();
		}
		
	}

}
