package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.data.CodigoMensaje;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.city.CityResponse;

@RestController
@RequestMapping("/general/api/v1/cities")
public class CityController {

	private RegisterNewCityInteractor registerNewCityInteractor;

	public CityController(RegisterNewCityInteractor registerNewCityInteractor) {
		super();
		this.registerNewCityInteractor = registerNewCityInteractor;
	}

	@PostMapping
	public ResponseEntity<CityResponse> registrarCiudad(@RequestBody RegisterNewCityDTO dto) {
		var httpStatusCode = HttpStatus.CREATED;
		var ciudadResponse = new CityResponse();

		try {
			registerNewCityInteractor.execute(dto);
			ciudadResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00005));

		} catch (final RuleUcobetException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(excepcion.getUserMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Se ha presentado un problema tratando de registrar la nueva ciudad";
			ciudadResponse.getMensajes().add(mensajeUsuario);
		}

		return new ResponseEntity<>(ciudadResponse, httpStatusCode);
	}

}
