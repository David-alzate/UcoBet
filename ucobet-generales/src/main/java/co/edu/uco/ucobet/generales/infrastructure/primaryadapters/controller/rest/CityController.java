package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.city.CityResponse;

@RestController
@RequestMapping("/general/api/v1/cities")
public class CityController {

	private RegisterNewCityInteractor registerNewCityInteractor;
	private final MessageHelper messageHelper;

	public CityController(RegisterNewCityInteractor registerNewCityInteractor, MessageHelper messageHelper) {
		this.registerNewCityInteractor = registerNewCityInteractor;
		this.messageHelper = messageHelper;
	}

	@PostMapping
	public ResponseEntity<CityResponse> registrarCiudad(@Validated @RequestBody RegisterNewCityDTO dto) {
		var httpStatusCode = HttpStatus.CREATED;
		var ciudadResponse = new CityResponse();

		try {
			registerNewCityInteractor.execute(dto);
			ciudadResponse.getMensajes().add(messageHelper.getMessage("M00005"));

		} catch (final RuleUcobetException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(excepcion.getUserMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = messageHelper.getMessage("M00006");
			ciudadResponse.getMensajes().add(mensajeUsuario);
		}

		return new ResponseEntity<>(ciudadResponse, httpStatusCode);
	}
}
