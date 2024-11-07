package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RetrieveStateDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.state.RetrieveStateInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.state.StateResponse;

@RestController
@RequestMapping("/general/api/v1/states")
public class StateController {
	
	private RetrieveStateInteractor retrieveStateInteractor;
	private final MessageHelper messageHelper;

	public StateController(RetrieveStateInteractor retrieveStateInteractor, MessageHelper messageHelper) {
		this.retrieveStateInteractor = retrieveStateInteractor;
		this.messageHelper = messageHelper;
	}
	
    @GetMapping
    public ResponseEntity<StateResponse> consultarEstados() {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var stateResponse = new StateResponse();

        try {
        	var stateDTO = RetrieveStateDTO.create();
        	stateResponse.setDatos(retrieveStateInteractor.execute(stateDTO));
            stateResponse.getMensajes().add(messageHelper.getMessage("M00007"));

        } catch (final UcobetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            stateResponse.getMensajes().add(excepcion.getUserMessage());
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = messageHelper.getMessage("M00014");
            stateResponse.getMensajes().add(mensajeUsuario);
        }

        return new ResponseEntity<>(stateResponse, httpStatusCode);
    }
	

}
