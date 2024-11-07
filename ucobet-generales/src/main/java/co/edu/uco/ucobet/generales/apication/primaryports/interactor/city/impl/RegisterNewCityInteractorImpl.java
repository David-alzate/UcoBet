package co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.apication.primaryports.mapper.RegisterNewCityMapper;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.crosscutting.exception.InteractorUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

@Service
@Transactional
public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {

	private RegisterNewCity registerNewCity;
	private final MessageHelper messageHelper;

	public RegisterNewCityInteractorImpl(RegisterNewCity registerNewCity, MessageHelper messageHelper) {
		this.registerNewCity = registerNewCity;
		this.messageHelper = messageHelper;
	}

	@Override
	public void execute(RegisterNewCityDTO data) {

		try {
			var cityDomain = RegisterNewCityMapper.INSTANCE.toDomain(data);
			registerNewCity.execute(cityDomain);
		} catch (UcobetException exception) {
			throw exception;
		} catch (Exception exception) {
			var userMessage = messageHelper.getMessage("M00006");
			var technicalMessage = messageHelper.getMessage("M00011");

			throw new InteractorUcobetException(userMessage, technicalMessage, exception);

		}

	}
}
