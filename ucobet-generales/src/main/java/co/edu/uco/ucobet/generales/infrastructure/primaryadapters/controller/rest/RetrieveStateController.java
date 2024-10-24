package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RetrieveStateDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.state.RetrieveStateInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcobetException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.StateResponse;

@RestController
@RequestMapping("/general/api/v1/states")
public class RetrieveStateController {
	
	private RetrieveStateInteractor retrieveStateInteractor;

	public RetrieveStateController(RetrieveStateInteractor retrieveStateInteractor) {
		this.retrieveStateInteractor = retrieveStateInteractor;
	}
	
    @GetMapping
    public ResponseEntity<StateResponse> consultarEstados() {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var stateResponse = new StateResponse();

        try {
        	var stateDTO = RetrieveStateDTO.create();
        	stateResponse.setDatos(retrieveStateInteractor.execute(stateDTO));
            stateResponse.getMensajes().add("Estados consultados exitosamente");

        } catch (final UcobetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            stateResponse.getMensajes().add(excepcion.getUserMessage());
            excepcion.printStackTrace();
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar los estados";
            stateResponse.getMensajes().add(mensajeUsuario);
            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(stateResponse, httpStatusCode);
    }
	

}
