package co.edu.uco.ucobet.generales.apication.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.apication.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.apication.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.apication.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.crosscutting.exception.NotificationServiceException;
import co.edu.uco.ucobet.generales.crosscutting.exception.UseCaseUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice.NotificationService;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.secretservice.SecretService;

@Service
public final class RegisterNewCityImpl implements RegisterNewCity {

	private CityRepository cityRepository;
	private RegisterNewCityRulesValidator registerNewCityRulesValidator;
	private NotificationService notificationService;
	private final MessageHelper messageHelper;
	private final SecretService secretService;

	public RegisterNewCityImpl(CityRepository cityRepository,
			RegisterNewCityRulesValidator registerNewCityRulesValidator, NotificationService notificationService,
			MessageHelper messageHelper, SecretService secretService) {
		if (ObjectHelper.isNull(cityRepository) || ObjectHelper.isNull(registerNewCityRulesValidator)) {
			var userMessage = messageHelper.getMessage("M00006");
			var technicalMessage = messageHelper.getMessage("M00012");
			throw new UseCaseUcobetException(userMessage, technicalMessage, new Exception());
		}
		this.cityRepository = cityRepository;
		this.registerNewCityRulesValidator = registerNewCityRulesValidator;
		this.notificationService = notificationService;
		this.messageHelper = messageHelper;
		this.secretService = secretService;
	}

	@Override
	public void execute(CityDomain domain) {
		registerNewCityRulesValidator.validate(domain);

		var cityEntity = CityEntity.create().setId(domain.getId()).setName(domain.getName())
				.setState(StateEntityMapper.INSTANCE.toEntity(domain.getState()));

		cityRepository.save(cityEntity);

		try {
			String correo = secretService.getSecretValue("correo");
			String asunto = secretService.getSecretValue("asunto");
			String mensaje = secretService.getSecretValue("mensaje");
			notificationService.sendNotification(correo, asunto, mensaje + domain.getName());
		} catch (NotificationServiceException exception) {
			throw new UseCaseUcobetException(messageHelper.getMessage("M00013"), exception.getMessage(), exception);
		}
	}

}
