package co.edu.uco.ucobet.generales.apication.usecase.city.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.apication.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.apication.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.apication.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.crosscutting.exception.NotificationServiceException;
import co.edu.uco.ucobet.generales.crosscutting.exception.UseCaseUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice.NotificationService;

@Service
public final class RegisterNewCityImpl implements RegisterNewCity {

	@Value("${correo}")
	private String correo;
	@Value("${asunto}")
	private String asunto;
	@Value("${mensaje}")
	private String mensaje;

	private CityRepository cityRepository;
	private RegisterNewCityRulesValidator registerNewCityRulesValidator;
	private NotificationService notificationService;

	public RegisterNewCityImpl(CityRepository cityRepository,
			RegisterNewCityRulesValidator registerNewCityRulesValidator, NotificationService notificationService) {
		if (ObjectHelper.isNull(cityRepository) || ObjectHelper.isNull(registerNewCityRulesValidator)) {
			var userMessage = "Se ha presentado un problema tratando de registrar la nueva ciudad";
			var technicalMessage = "El repository o las rules para Registrar el cliente llegó nulo...";
			throw new UseCaseUcobetException(userMessage, technicalMessage, new Exception());
		}

		this.cityRepository = cityRepository;
		this.registerNewCityRulesValidator = registerNewCityRulesValidator;
		this.notificationService = notificationService;
	}

	@Override
	public void execute(CityDomain domain) {
	    registerNewCityRulesValidator.validate(domain);

	    var cityEntity = CityEntity.create()
	        .setId(domain.getId())
	        .setName(domain.getName())
	        .setState(StateEntityMapper.INSTANCE.toEntity(domain.getState()));

	    cityRepository.save(cityEntity);

	    try {
	        notificationService.sendNotification(correo, asunto, mensaje + domain.getName());
	    } catch (NotificationServiceException exception) {
	        throw new UseCaseUcobetException("Error al enviar la notificación para la ciudad", exception.getMessage(), exception);
	    }
	}

}
