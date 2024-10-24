package co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.apication.primaryports.mapper.RegisterNewCityMapper;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCity;

@Service
@Transactional
public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {

	private RegisterNewCity registerNewCity;

	public RegisterNewCityInteractorImpl(RegisterNewCity registerNewCity) {
		this.registerNewCity = registerNewCity;
	}

	@Override
	public void execute(RegisterNewCityDTO data) {
		var cityDomain = RegisterNewCityMapper.INSTANCE.toDomain(data);
		registerNewCity.execute(cityDomain);

	}

}
