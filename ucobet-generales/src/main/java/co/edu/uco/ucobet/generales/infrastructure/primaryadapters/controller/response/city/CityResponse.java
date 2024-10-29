package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.city;

import java.util.ArrayList;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.Response;

public class CityResponse extends Response<RegisterNewCityDTO>{
	
	public CityResponse() {
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }

	
}