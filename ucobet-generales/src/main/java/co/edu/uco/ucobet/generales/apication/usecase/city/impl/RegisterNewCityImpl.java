package co.edu.uco.ucobet.generales.apication.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.apication.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.apication.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.apication.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.crosscutting.exception.UseCaseUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Service
public final class RegisterNewCityImpl implements RegisterNewCity {

	private CityRepository cityRepository;
	private RegisterNewCityRulesValidator registerNewCityRulesValidator;

	public RegisterNewCityImpl(CityRepository cityRepository,
			RegisterNewCityRulesValidator registerNewCityRulesValidator) {
		if (ObjectHelper.isNull(cityRepository) || ObjectHelper.isNull(registerNewCityRulesValidator)) {
			var userMessage = "Se ha presentado un problema tratando de llevar a cabo el Registro de la ciudad...";
			var technicalMessage = "El repository o las rules para Registrar el cliente llegó nulo...";
			throw new UseCaseUcobetException(userMessage, technicalMessage, new Exception());
		}

		this.cityRepository = cityRepository;
		this.registerNewCityRulesValidator = registerNewCityRulesValidator;
	}

	@Override
	public void execute(CityDomain domain) {

		registerNewCityRulesValidator.validate(domain);

		var cityEntity = CityEntity.create().setId(domain.getId()).setName(domain.getName())
				.setState(StateEntityMapper.INSTANCE.toEntity(domain.getState()));

		cityRepository.save(cityEntity);

		// Notificar al administrador sobre la creacion de la nueva ciudad

		// 1. El correo del administrador esta en un lugar parametrizado (Parametres
		// Building Block)
		// 2. El asunto del correo esta en un lugar parametrizado
		// 3: El cuerpo del correo esta en un lugar parametrizado

	}

}
