package co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.apication.primaryports.mapper.RegisterNewCityMapper;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.crosscutting.exception.InteractorUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcobetException;

@Service
@Transactional
public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {

	private RegisterNewCity registerNewCity;

	public RegisterNewCityInteractorImpl(RegisterNewCity registerNewCity) {
		this.registerNewCity = registerNewCity;
	}

	@Override
	public void execute(RegisterNewCityDTO data) {

		try {
			var cityDomain = RegisterNewCityMapper.INSTANCE.toDomain(data);
			registerNewCity.execute(cityDomain);
		} catch (UcobetException exception) {
			throw exception;
		} catch (Exception exception) {
			var userMessage = "Se ha presentado un problema tratando de registrar la nueva ciudad";
			var technicalMessage = "Se ha presentado un problema INESPERADO tratando de Registrar la información de la ciudad.";

			throw new InteractorUcobetException(userMessage, technicalMessage, exception);

		}

	}
}
