package co.edu.uco.ucobet.generales.apication.usecase.city.impl;

import co.edu.uco.ucobet.generales.apication.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.apication.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

public final class RegisterNewCityImpl implements RegisterNewCity {

	private CityRepository cityRepository;
	private RegisterNewCityRulesValidator registerNewCityRulesValidator;
	
	public RegisterNewCityImpl(CityRepository cityRepository,
			RegisterNewCityRulesValidator registerNewCityRulesValidator) {
		super();
		this.cityRepository = cityRepository;
		this.registerNewCityRulesValidator = registerNewCityRulesValidator;
	}

	@Override
	public void execute(CityDomain domain) {

		// Rules validation
		registerNewCityRulesValidator.validate(domain);

		// Data Mapper -> Domain -> Entity
		final var cityEntity = CityEntity.create(null);

		// Save CityEntity
		cityRepository.save(cityEntity);
		
		// Notificar al administrador sobre la creacion de la nueva ciudad 
		
		//1. El correo del administrador esta en un lugar parametrizado (Parametres Building Block)
		//2. El asunto del correo esta en un lugar parametrizado
		//3: El cuerpo del correo esta en un lugar parametrizado

	}

}
