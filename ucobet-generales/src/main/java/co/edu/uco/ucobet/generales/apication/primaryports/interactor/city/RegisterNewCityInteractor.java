package co.edu.uco.ucobet.generales.apication.primaryports.interactor.city;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.InteractorWithOutReturn;

@Service
@Transactional
public interface RegisterNewCityInteractor extends InteractorWithOutReturn<RegisterNewCityDTO> {

}
