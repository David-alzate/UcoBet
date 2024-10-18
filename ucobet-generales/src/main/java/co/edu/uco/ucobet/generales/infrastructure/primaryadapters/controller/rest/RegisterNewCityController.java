package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.RegisterNewCityInteractor;

@RestController
@RequestMapping("/general/api/v1/cities")
public class RegisterNewCityController {

	private RegisterNewCityInteractor registerNewCityInteractor;

	public RegisterNewCityController(RegisterNewCityInteractor registerNewCityInteractor) {
		super();
		this.registerNewCityInteractor = registerNewCityInteractor;
	}

	@PostMapping
	public RegisterNewCityDTO execute(@RequestBody RegisterNewCityDTO dto) {
		registerNewCityInteractor.execute(dto);

		return dto;
	}
	
//	@GetMapping
//	public RegisterNewCityDTO executeDummy() {
//		return RegisterNewCityDTO.create("Rionegro", )
//	}

}
