package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.state;

import java.util.ArrayList;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RetrieveStateDTO;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.Response;

public class StateResponse extends Response<RetrieveStateDTO> {

	public StateResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}