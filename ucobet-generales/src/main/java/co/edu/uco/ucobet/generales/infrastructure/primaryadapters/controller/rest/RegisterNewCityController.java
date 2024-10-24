package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.CiudadResponse;

@RestController
@RequestMapping("/general/api/v1/cities")
public class RegisterNewCityController {


	private RegisterNewCityInteractor registerNewCityInteractor;

	public RegisterNewCityController(RegisterNewCityInteractor registerNewCityInteractor) {
		super();
		this.registerNewCityInteractor = registerNewCityInteractor;
	}

	@PostMapping
    public ResponseEntity<CiudadResponse> registrarCiudad(@RequestBody RegisterNewCityDTO dto) {
        var httpStatusCode = HttpStatus.CREATED;
        var ciudadResponse = new CiudadResponse();

        try {
            registerNewCityInteractor.execute(dto);
            ciudadResponse.getMensajes().add("Ciudad registrada exitosamente");

        } catch (final UcobetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            ciudadResponse.getMensajes().add(excepcion.getUserMessage());
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar la nueva ciudad";
            ciudadResponse.getMensajes().add(mensajeUsuario);
        }

        return new ResponseEntity<>(ciudadResponse, httpStatusCode);
    }

	@GetMapping
	public RegisterNewCityDTO executeDummy() {
		return RegisterNewCityDTO.create("Rionegro", UUIDHelper.getDefault());
	}

}
