package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.city;

import java.util.ArrayList;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RetrieveCityDTO;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.Response;

public class RetrieveCityResponse extends Response<RetrieveCityDTO>{
	
	public RetrieveCityResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
