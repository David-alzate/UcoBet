package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import co.edu.uco.ucobet.generales.apication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.dto.RetrieveCityDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.RetrieveCityInteractor;
import co.edu.uco.ucobet.generales.apication.usecase.city.impl.RegisterNewCityImpl;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.SanitizerHelper;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.city.RegisterNewCityResponse;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.city.RetrieveCityResponse;

@RestController
@RequestMapping("/general/api/v1/cities")
public class CityController {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(RegisterNewCityImpl.class);

	private RegisterNewCityInteractor registerNewCityInteractor;
	private RetrieveCityInteractor retrieveCityInteractor;
	private final MessageHelper messageHelper;
	private final SanitizerHelper sanitizerHelper;

	public CityController(RegisterNewCityInteractor registerNewCityInteractor, MessageHelper messageHelper, RetrieveCityInteractor retrieveCityInteractor, SanitizerHelper sanitizerHelper) {
		this.registerNewCityInteractor = registerNewCityInteractor;
		this.messageHelper = messageHelper;
		this.retrieveCityInteractor = retrieveCityInteractor;
		this.sanitizerHelper = sanitizerHelper;
	}

	@PostMapping
	public ResponseEntity<RegisterNewCityResponse> registrarCiudad(@RequestBody RegisterNewCityDTO dto) {
	    var httpStatusCode = HttpStatus.CREATED;
	    var ciudadResponse = new RegisterNewCityResponse();

	    try {
	        dto.setCityName(sanitizerHelper.sanitizeInput(dto.getCityName()));
	        registerNewCityInteractor.execute(dto);
	        ciudadResponse.getMensajes().add(messageHelper.getMessage("M00005"));

	    } catch (final RuleUcobetException excepcion) {
	        httpStatusCode = HttpStatus.BAD_REQUEST;
	        ciudadResponse.getMensajes().add(excepcion.getUserMessage());
	        logger.error("Excepción capturada: {}", excepcion.getMessage(), excepcion);

	    } catch (final Exception excepcion) {
	        httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	        var mensajeUsuario = messageHelper.getMessage("M00006");
	        ciudadResponse.getMensajes().add(mensajeUsuario);
	    }

	    return new ResponseEntity<>(ciudadResponse, httpStatusCode);
	}
	
    @GetMapping
    public ResponseEntity<RetrieveCityResponse> consultarEstados() {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var cityResponse = new RetrieveCityResponse();

        try {
        	var cityDTO = RetrieveCityDTO.create();
        	cityResponse.setDatos(retrieveCityInteractor.execute(cityDTO));
        	cityResponse.getMensajes().add("Ciudades consultados exitosamente");

        } catch (final UcobetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            cityResponse.getMensajes().add(excepcion.getUserMessage());
            excepcion.printStackTrace();
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las ciudades";
            cityResponse.getMensajes().add(mensajeUsuario);
            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(cityResponse, httpStatusCode);
    }
   
}
