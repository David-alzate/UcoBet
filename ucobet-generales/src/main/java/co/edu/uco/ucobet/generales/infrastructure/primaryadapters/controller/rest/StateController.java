package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RetrieveStateDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.state.RetrieveStateInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.data.CodigoMensaje;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.state.StateResponse;

@RestController
@RequestMapping("/general/api/v1/states")
public class StateController {
	
	private RetrieveStateInteractor retrieveStateInteractor;

	public StateController(RetrieveStateInteractor retrieveStateInteractor) {
		this.retrieveStateInteractor = retrieveStateInteractor;
	}
	
    @GetMapping
    public ResponseEntity<StateResponse> consultarEstados() {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var stateResponse = new StateResponse();

        try {
        	var stateDTO = RetrieveStateDTO.create();
        	stateResponse.setDatos(retrieveStateInteractor.execute(stateDTO));
            stateResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00007));

        } catch (final UcobetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            stateResponse.getMensajes().add(excepcion.getUserMessage());
            excepcion.printStackTrace();
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00008);
            stateResponse.getMensajes().add(mensajeUsuario);
            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(stateResponse, httpStatusCode);
    }
	

}
