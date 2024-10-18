package co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.impl;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.apication.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

public final class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {

	private RegisterNewCity registerNewCity;

	public RegisterNewCityInteractorImpl(RegisterNewCity registerNewCity) {
		super();
		this.registerNewCity = registerNewCity;
	}

	@Override
	public void execute(RegisterNewCityDTO data) {
		// DataMapper -> DTO -> Domain
		final var cityDomain = new CityDomain(null, null, null);

		registerNewCity.execute(cityDomain);

	}

}
