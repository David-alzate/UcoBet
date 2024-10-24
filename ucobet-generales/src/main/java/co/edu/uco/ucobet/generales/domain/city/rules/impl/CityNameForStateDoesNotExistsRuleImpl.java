package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.apication.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.apication.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.apication.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameForStateDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistsRule;

@Service
public class CityNameForStateDoesNotExistsRuleImpl implements CityNameForStateDoesNotExistsRule {

	private CityRepository cityRepository;

	public CityNameForStateDoesNotExistsRuleImpl(final CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public void validate(CityDomain data) {

		var cityEntityFilter = CityEntity.create().setName(data.getName())
				.setState(StateEntityMapper.INSTANCE.toEntity(data.getState()));

		var resultados = cityRepository.findByFilter(cityEntityFilter);

		if (!resultados.isEmpty()) {
			throw CityNameForStateDoesExistsException.create();
		}

	}

}
